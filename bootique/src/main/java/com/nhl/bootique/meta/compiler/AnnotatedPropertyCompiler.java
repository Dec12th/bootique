package com.nhl.bootique.meta.compiler;

import com.nhl.bootique.log.BootLogger;
import com.nhl.bootique.meta.ConfigMetadata;
import com.nhl.bootique.meta.annotation.ConfigObjectProperty;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @since 0.19
 */
class AnnotatedPropertyCompiler {

    private BootLogger logger;
    private Pattern setterPattern;
    private ConfigMetadataCompiler compiler;

    AnnotatedPropertyCompiler(BootLogger logger, ConfigMetadataCompiler compiler) {
        this.logger = logger;
        this.compiler = compiler;
        this.setterPattern = Pattern.compile("^set([\\p{javaJavaIdentifierStart}_$])([\\p{javaJavaIdentifierPart}]*)$");
    }

    Map<String, ConfigMetadata> findProperties(Class<?> type) {

        // ensure sorting by property name for consistency
        Map<String, ConfigMetadata> properties = new TreeMap<>();

        // find methods... this includes superclass methods...
        for (Method m : type.getMethods()) {
            appendPropertyFromMethod(properties, m);
        }

        return properties;
    }

    boolean appendPropertyFromMethod(Map<String, ConfigMetadata> properties, Method m) {
        ConfigObjectProperty propAnnotation = m.getAnnotation(ConfigObjectProperty.class);
        if (propAnnotation == null) {
            return false;
        }

        String propertyName = propertyName(m.getName());
        if (propertyName == null) {
            logger.stderr("Annotated config method is not a setter: '" + m.getName() + "'");
            return false;
        }

        Class<?>[] parameterTypes = m.getParameterTypes();
        if (parameterTypes.length != 1) {
            logger.stderr("Invalid parameter count for config setter '" + m.getName() + "'. Expected 1, was: " + parameterTypes.length);
            return false;
        }

        if (!Void.TYPE.equals(m.getReturnType())) {
            logger.stderr("Config setter '" + m.getName() + "' expected to ve void. Instead returns: " + m.getReturnType().getName());
            return false;
        }

        properties.put(propertyName, getOrCreateConfig(parameterTypes[0], propAnnotation));
        return true;
    }

    ConfigMetadata getOrCreateConfig(Class<?> type, ConfigObjectProperty annotation) {
        return compiler.compile(type, annotation.description());
    }

    String propertyName(String setterName) {
        Matcher matcher = setterPattern.matcher(setterName);
        if (!matcher.find()) {
            return null;
        }
        return matcher.group(1).toLowerCase() + matcher.group(2);
    }
}
