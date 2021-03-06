package org.jeroen.ddd.specification.basic;

/**
 * Determine if a property value is greater than the specified value.
 * 
 * @author Jeroen van Schagen
 * @since 5-1-2011
 *
 * @param <T> type of candidates being checked
 */
public class GreaterThanSpecification<T> extends CompareToSpecification<T> {
    private static final int GREATER_THAN_COMPARISON = 1;

    /**
     * Construct a new {@link GreaterThanSpecification}.
     * @param property determines what property should be verified
     * @param value candidates are only matched when their property value is above this value
     */
    public GreaterThanSpecification(String property, Object value) {
        super(property, value, GREATER_THAN_COMPARISON);
    }

}
