/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EDynamic State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEDynamicState()
 * @model
 * @generated
 */
public enum EDynamicState implements Enumerator
{
	/**
	 * The '<em><b>VIEWPORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEWPORT_VALUE
	 * @generated
	 * @ordered
	 */
	VIEWPORT(0, "VIEWPORT", "VIEWPORT"),

	/**
	 * The '<em><b>SCISSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCISSOR_VALUE
	 * @generated
	 * @ordered
	 */
	SCISSOR(1, "SCISSOR", "SCISSOR"),

	/**
	 * The '<em><b>LINE WIDTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_WIDTH_VALUE
	 * @generated
	 * @ordered
	 */
	LINE_WIDTH(2, "LINE_WIDTH", "LINE_WIDTH"),

	/**
	 * The '<em><b>DEPTH BIAS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_BIAS_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_BIAS(3, "DEPTH_BIAS", "DEPTH_BIAS"),

	/**
	 * The '<em><b>BLEND CONSTANTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLEND_CONSTANTS_VALUE
	 * @generated
	 * @ordered
	 */
	BLEND_CONSTANTS(4, "BLEND_CONSTANTS", "BLEND_CONSTANTS"),

	/**
	 * The '<em><b>DEPTH BOUNDS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_BOUNDS_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_BOUNDS(5, "DEPTH_BOUNDS", "DEPTH_BOUNDS"),

	/**
	 * The '<em><b>STENCIL COMPARE MASK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STENCIL_COMPARE_MASK_VALUE
	 * @generated
	 * @ordered
	 */
	STENCIL_COMPARE_MASK(6, "STENCIL_COMPARE_MASK", "STENCIL_COMPARE_MASK"),

	/**
	 * The '<em><b>STENCIL WRITE MASK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STENCIL_WRITE_MASK_VALUE
	 * @generated
	 * @ordered
	 */
	STENCIL_WRITE_MASK(7, "STENCIL_WRITE_MASK", "STENCIL_WRITE_MASK"),

	/**
	 * The '<em><b>STENCIL REFERENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STENCIL_REFERENCE_VALUE
	 * @generated
	 * @ordered
	 */
	STENCIL_REFERENCE(8, "STENCIL_REFERENCE", "STENCIL_REFERENCE");

	/**
	 * The '<em><b>VIEWPORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEWPORT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VIEWPORT_VALUE = 0;

	/**
	 * The '<em><b>SCISSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCISSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCISSOR_VALUE = 1;

	/**
	 * The '<em><b>LINE WIDTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_WIDTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_WIDTH_VALUE = 2;

	/**
	 * The '<em><b>DEPTH BIAS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_BIAS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_BIAS_VALUE = 3;

	/**
	 * The '<em><b>BLEND CONSTANTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLEND_CONSTANTS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLEND_CONSTANTS_VALUE = 4;

	/**
	 * The '<em><b>DEPTH BOUNDS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_BOUNDS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_BOUNDS_VALUE = 5;

	/**
	 * The '<em><b>STENCIL COMPARE MASK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STENCIL_COMPARE_MASK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STENCIL_COMPARE_MASK_VALUE = 6;

	/**
	 * The '<em><b>STENCIL WRITE MASK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STENCIL_WRITE_MASK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STENCIL_WRITE_MASK_VALUE = 7;

	/**
	 * The '<em><b>STENCIL REFERENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STENCIL_REFERENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STENCIL_REFERENCE_VALUE = 8;

	/**
	 * An array of all the '<em><b>EDynamic State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EDynamicState[] VALUES_ARRAY = new EDynamicState[] {
			VIEWPORT,
			SCISSOR,
			LINE_WIDTH,
			DEPTH_BIAS,
			BLEND_CONSTANTS,
			DEPTH_BOUNDS,
			STENCIL_COMPARE_MASK,
			STENCIL_WRITE_MASK,
			STENCIL_REFERENCE,
	};

	/**
	 * A public read-only list of all the '<em><b>EDynamic State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EDynamicState> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EDynamic State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EDynamicState get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EDynamicState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EDynamic State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EDynamicState getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EDynamicState result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EDynamic State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EDynamicState get(int value)
	{
		switch (value)
		{
		case VIEWPORT_VALUE:
			return VIEWPORT;
		case SCISSOR_VALUE:
			return SCISSOR;
		case LINE_WIDTH_VALUE:
			return LINE_WIDTH;
		case DEPTH_BIAS_VALUE:
			return DEPTH_BIAS;
		case BLEND_CONSTANTS_VALUE:
			return BLEND_CONSTANTS;
		case DEPTH_BOUNDS_VALUE:
			return DEPTH_BOUNDS;
		case STENCIL_COMPARE_MASK_VALUE:
			return STENCIL_COMPARE_MASK;
		case STENCIL_WRITE_MASK_VALUE:
			return STENCIL_WRITE_MASK;
		case STENCIL_REFERENCE_VALUE:
			return STENCIL_REFERENCE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDynamicState(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral()
	{
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}

} //EDynamicState
