package org.jdesktop.swingxset.util;

import java.util.Locale;
import java.util.Map;

import org.jdesktop.swingx.util.Contract;

import org.jdesktop.swingx.renderer.StringValue;
import org.jdesktop.swingx.renderer.StringValues;
/**
 * A StringValue which looks up localized String representations for objects
 * from the context of Application.<p>
 * 
 * Note: the LocalizableStringValue of Swingx should be factored to allow
 * subclassing to configure the exact lookup.
 */
public class ResourceMapStringValue implements StringValue {

    private Map<Object, String> lookup;

    private Locale locale;

    private String prefix;

    private Class<?> baseClass;

    /**
     * Instantiates a LocaleStringValue which looks up localized String
     * representations for items in the map using the JComponent defaultLocale.
     * 
     * @param lookup a map containing Entries of objects and a string key to
     *        look up its string representation in the UIManager
     */
    public ResourceMapStringValue(Map<Object, String> lookup) {
        this(lookup, (String) null, (Locale) null);
    }

    /**
     * Instantiates a LocaleStringValue which looks up localized String
     * representations for items in the map using the given Locale.
     * 
     * @param lookup a map containing Entries of objects and a string key to
     *        look up its string representation in the UIManager
     * @param locale the locale to lookup the localized strings, may be null to
     *        denote using JComponent.defaultLocale
     */
    public ResourceMapStringValue(Map<Object, String> lookup, Locale locale) {
        this(lookup, null, locale);
    }

    /**
     * Instantiates a LocaleStringValue which looks up localized String
     * representations for items in the map using the JComponent defaultLocale.
     * 
     * @param lookup a map containing Entries of objects and a string key to
     *        look up its string representation in the UIManager
     * @param prefix a common prefix for all string keys in the map, may be null
     *    to denote that the keys should be use as are 
     */
    public ResourceMapStringValue(Map<Object, String> lookup, String prefix) {
        this(lookup, prefix, (Locale) null);
    }

    /**
     * Instantiates a LocaleStringValue which looks up localized String
     * representations for items in the map using the given Locale.
     * 
     * @param lookup a map containing Entries of objects and a string key to
     *        look up its string representation in the UIManager
     * @param prefix a common prefix for all string keys in the map, may be null
     *    to denote that the keys should be use as are 
     * @param locale the locale to lookup the localized strings, may be null to
     *        denote using JComponent.defaultLocale
     */
    public ResourceMapStringValue(Map<Object, String> lookup, String prefix,
            Locale locale) {
        this.lookup = Contract.asNotNull(lookup, "map must not be null");
        this.prefix = prefix;
        setLocale(locale);
    }

    public ResourceMapStringValue(Map<Object, String> lookup, String prefix, Class<?> base) {
        this(lookup, prefix, (Locale) null);
        this.baseClass = base;
    }
    /**
     * 
     * @inherited <p>
     * 
     *            Implemented to lookup the value's localized string
     *            representation, if contained in the lookup map. Returns
     *            toString if not.
     * 
     */
    @Override
    public String getString(Object value) {
        String key = lookup.get(value);
        if (key != null) {
            if (prefix != null) {
                key = prefix + key;
            }
            String text = doLookup(key);
            if (text != null)
                return text;
        }
        return StringValues.TO_STRING_UI.getString(value);
    }

    protected String doLookup(String key) {
        return DemoUtils.getResourceString(baseClass, key);
    }

    // -------------------- implement Localizable

    /**
     * Sets the Locale to use for lookup of localized string representation.
     * 
     * @param locale the locale to lookup the localized strings, may be null to
     *        denote using Locale's default.
     */
    public final void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Returns the Locale to use for lookup, guaranteed to be not null. If
     * the initial setting had been null, returns current Locale's default.
     * 
     * @return the Locale used for lookup.
     */
    public Locale getLocale() {
        return locale != null ? locale : Locale.getDefault();
    }
}