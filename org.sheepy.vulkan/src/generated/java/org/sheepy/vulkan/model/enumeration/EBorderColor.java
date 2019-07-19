/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EBorder Color</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEBorderColor()
 * @model
 * @generated
 */
public enum EBorderColor implements Enumerator
{
	/**
	 * The '<em><b>FLOAT TRANSPARENT BLACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_TRANSPARENT_BLACK_VALUE
	 * @generated
	 * @ordered
	 */
	FLOAT_TRANSPARENT_BLACK(0, "FLOAT_TRANSPARENT_BLACK", "FLOAT_TRANSPARENT_BLACK"),

	/**
	 * The '<em><b>INT TRANSPARENT BLACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_TRANSPARENT_BLACK_VALUE
	 * @generated
	 * @ordered
	 */
	INT_TRANSPARENT_BLACK(1, "INT_TRANSPARENT_BLACK", "INT_TRANSPARENT_BLACK"),

	/**
	 * The '<em><b>FLOAT OPAQUE BLACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_OPAQUE_BLACK_VALUE
	 * @generated
	 * @ordered
	 */
	FLOAT_OPAQUE_BLACK(2, "FLOAT_OPAQUE_BLACK", "FLOAT_OPAQUE_BLACK"),

	/**
	 * The '<em><b>INT OPAQUE BLACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_OPAQUE_BLACK_VALUE
	 * @generated
	 * @ordered
	 */
	INT_OPAQUE_BLACK(3, "INT_OPAQUE_BLACK", "INT_OPAQUE_BLACK"),

	/**
	 * The '<em><b>FLOAT OPAQUE WHITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_OPAQUE_WHITE_VALUE
	 * @generated
	 * @ordered
	 */
	FLOAT_OPAQUE_WHITE(4, "FLOAT_OPAQUE_WHITE", "FLOAT_OPAQUE_WHITE"),

	/**
	 * The '<em><b>INT OPAQUE WHITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_OPAQUE_WHITE_VALUE
	 * @generated
	 * @ordered
	 */
	INT_OPAQUE_WHITE(5, "INT_OPAQUE_WHITE", "INT_OPAQUE_WHITE");

	/**
	 * The '<em><b>FLOAT TRANSPARENT BLACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_TRANSPARENT_BLACK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_TRANSPARENT_BLACK_VALUE = 0;

	/**
	 * The '<em><b>INT TRANSPARENT BLACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_TRANSPARENT_BLACK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT_TRANSPARENT_BLACK_VALUE = 1;

	/**
	 * The '<em><b>FLOAT OPAQUE BLACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_OPAQUE_BLACK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_OPAQUE_BLACK_VALUE = 2;

	/**
	 * The '<em><b>INT OPAQUE BLACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_OPAQUE_BLACK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT_OPAQUE_BLACK_VALUE = 3;

	/**
	 * The '<em><b>FLOAT OPAQUE WHITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT_OPAQUE_WHITE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT_OPAQUE_WHITE_VALUE = 4;

	/**
	 * The '<em><b>INT OPAQUE WHITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_OPAQUE_WHITE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT_OPAQUE_WHITE_VALUE = 5;

	/**
	 * An array of all the '<em><b>EBorder Color</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EBorderColor[] VALUES_ARRAY = new EBorderColor[]
		{
			FLOAT_TRANSPARENT_BLACK,
			INT_TRANSPARENT_BLACK,
			FLOAT_OPAQUE_BLACK,
			INT_OPAQUE_BLACK,
			FLOAT_OPAQUE_WHITE,
			INT_OPAQUE_WHITE,
		};

	/**
	 * A public read-only list of all the '<em><b>EBorder Color</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EBorderColor> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EBorder Color</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBorderColor get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EBorderColor result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EBorder Color</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBorderColor getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EBorderColor result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EBorder Color</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBorderColor get(int value)
	{
		switch (value)
		{
			case FLOAT_TRANSPARENT_BLACK_VALUE: return FLOAT_TRANSPARENT_BLACK;
			case INT_TRANSPARENT_BLACK_VALUE: return INT_TRANSPARENT_BLACK;
			case FLOAT_OPAQUE_BLACK_VALUE: return FLOAT_OPAQUE_BLACK;
			case INT_OPAQUE_BLACK_VALUE: return INT_OPAQUE_BLACK;
			case FLOAT_OPAQUE_WHITE_VALUE: return FLOAT_OPAQUE_WHITE;
			case INT_OPAQUE_WHITE_VALUE: return INT_OPAQUE_WHITE;
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
	private EBorderColor(int value, String name, String literal)
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

} //EBorderColor
