/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EBlend Factor</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEBlendFactor()
 * @model
 * @generated
 */
public enum EBlendFactor implements Enumerator
{
	/**
	 * The '<em><b>ZERO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZERO_VALUE
	 * @generated
	 * @ordered
	 */
	ZERO(0, "ZERO", "ZERO"),

	/**
	 * The '<em><b>ONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_VALUE
	 * @generated
	 * @ordered
	 */
	ONE(1, "ONE", "ONE"),

	/**
	 * The '<em><b>SRC COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SRC_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	SRC_COLOR(2, "SRC_COLOR", "SRC_COLOR"),

	/**
	 * The '<em><b>ONE MINUS SRC COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_SRC_COLOR(3, "ONE_MINUS_SRC_COLOR", "ONE_MINUS_SRC_COLOR"),

	/**
	 * The '<em><b>DST COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DST_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	DST_COLOR(4, "DST_COLOR", "DST_COLOR"),

	/**
	 * The '<em><b>ONE MINUS DST COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_DST_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_DST_COLOR(5, "ONE_MINUS_DST_COLOR", "ONE_MINUS_DST_COLOR"),

	/**
	 * The '<em><b>SRC ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SRC_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	SRC_ALPHA(6, "SRC_ALPHA", "SRC_ALPHA"),

	/**
	 * The '<em><b>ONE MINUS SRC ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_SRC_ALPHA(7, "ONE_MINUS_SRC_ALPHA", "ONE_MINUS_SRC_ALPHA"),

	/**
	 * The '<em><b>DST ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DST_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	DST_ALPHA(8, "DST_ALPHA", "DST_ALPHA"),

	/**
	 * The '<em><b>ONE MINUS DST ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_DST_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_DST_ALPHA(9, "ONE_MINUS_DST_ALPHA", "ONE_MINUS_DST_ALPHA"),

	/**
	 * The '<em><b>CONSTANT COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTANT_COLOR(10, "CONSTANT_COLOR", "CONSTANT_COLOR"),

	/**
	 * The '<em><b>ONE MINUS CONSTANT COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_CONSTANT_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_CONSTANT_COLOR(11, "ONE_MINUS_CONSTANT_COLOR", "ONE_MINUS_CONSTANT_COLOR"),

	/**
	 * The '<em><b>CONSTANT ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTANT_ALPHA(12, "CONSTANT_ALPHA", "CONSTANT_ALPHA"),

	/**
	 * The '<em><b>ONE MINUS CONSTANT ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_CONSTANT_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_CONSTANT_ALPHA(13, "ONE_MINUS_CONSTANT_ALPHA", "ONE_MINUS_CONSTANT_ALPHA"),

	/**
	 * The '<em><b>SRC ALPHA SATURATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SRC_ALPHA_SATURATE_VALUE
	 * @generated
	 * @ordered
	 */
	SRC_ALPHA_SATURATE(14, "SRC_ALPHA_SATURATE", "SRC_ALPHA_SATURATE"),

	/**
	 * The '<em><b>SRC1 COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SRC1_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	SRC1_COLOR(15, "SRC1_COLOR", "SRC1_COLOR"),

	/**
	 * The '<em><b>ONE MINUS SRC1 COLOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC1_COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_SRC1_COLOR(16, "ONE_MINUS_SRC1_COLOR", "ONE_MINUS_SRC1_COLOR"),

	/**
	 * The '<em><b>SRC1 ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SRC1_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	SRC1_ALPHA(17, "SRC1_ALPHA", "SRC1_ALPHA"),

	/**
	 * The '<em><b>ONE MINUS SRC1 ALPHA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC1_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_MINUS_SRC1_ALPHA(18, "ONE_MINUS_SRC1_ALPHA", "ONE_MINUS_SRC1_ALPHA");

	/**
	 * The '<em><b>ZERO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZERO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZERO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZERO_VALUE = 0;

	/**
	 * The '<em><b>ONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_VALUE = 1;

	/**
	 * The '<em><b>SRC COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SRC COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SRC_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SRC_COLOR_VALUE = 2;

	/**
	 * The '<em><b>ONE MINUS SRC COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS SRC COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_SRC_COLOR_VALUE = 3;

	/**
	 * The '<em><b>DST COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DST COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DST_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DST_COLOR_VALUE = 4;

	/**
	 * The '<em><b>ONE MINUS DST COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS DST COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_DST_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_DST_COLOR_VALUE = 5;

	/**
	 * The '<em><b>SRC ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SRC ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SRC_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SRC_ALPHA_VALUE = 6;

	/**
	 * The '<em><b>ONE MINUS SRC ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS SRC ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_SRC_ALPHA_VALUE = 7;

	/**
	 * The '<em><b>DST ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DST ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DST_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DST_ALPHA_VALUE = 8;

	/**
	 * The '<em><b>ONE MINUS DST ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS DST ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_DST_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_DST_ALPHA_VALUE = 9;

	/**
	 * The '<em><b>CONSTANT COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTANT COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_COLOR_VALUE = 10;

	/**
	 * The '<em><b>ONE MINUS CONSTANT COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS CONSTANT COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_CONSTANT_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_CONSTANT_COLOR_VALUE = 11;

	/**
	 * The '<em><b>CONSTANT ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSTANT ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTANT_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSTANT_ALPHA_VALUE = 12;

	/**
	 * The '<em><b>ONE MINUS CONSTANT ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS CONSTANT ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_CONSTANT_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_CONSTANT_ALPHA_VALUE = 13;

	/**
	 * The '<em><b>SRC ALPHA SATURATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SRC ALPHA SATURATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SRC_ALPHA_SATURATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SRC_ALPHA_SATURATE_VALUE = 14;

	/**
	 * The '<em><b>SRC1 COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SRC1 COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SRC1_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SRC1_COLOR_VALUE = 15;

	/**
	 * The '<em><b>ONE MINUS SRC1 COLOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS SRC1 COLOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC1_COLOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_SRC1_COLOR_VALUE = 16;

	/**
	 * The '<em><b>SRC1 ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SRC1 ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SRC1_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SRC1_ALPHA_VALUE = 17;

	/**
	 * The '<em><b>ONE MINUS SRC1 ALPHA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE MINUS SRC1 ALPHA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_MINUS_SRC1_ALPHA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_MINUS_SRC1_ALPHA_VALUE = 18;

	/**
	 * An array of all the '<em><b>EBlend Factor</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EBlendFactor[] VALUES_ARRAY =
		new EBlendFactor[]
		{
			ZERO,
			ONE,
			SRC_COLOR,
			ONE_MINUS_SRC_COLOR,
			DST_COLOR,
			ONE_MINUS_DST_COLOR,
			SRC_ALPHA,
			ONE_MINUS_SRC_ALPHA,
			DST_ALPHA,
			ONE_MINUS_DST_ALPHA,
			CONSTANT_COLOR,
			ONE_MINUS_CONSTANT_COLOR,
			CONSTANT_ALPHA,
			ONE_MINUS_CONSTANT_ALPHA,
			SRC_ALPHA_SATURATE,
			SRC1_COLOR,
			ONE_MINUS_SRC1_COLOR,
			SRC1_ALPHA,
			ONE_MINUS_SRC1_ALPHA,
		};

	/**
	 * A public read-only list of all the '<em><b>EBlend Factor</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EBlendFactor> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EBlend Factor</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBlendFactor get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EBlendFactor result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EBlend Factor</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBlendFactor getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EBlendFactor result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EBlend Factor</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBlendFactor get(int value)
	{
		switch (value)
		{
			case ZERO_VALUE: return ZERO;
			case ONE_VALUE: return ONE;
			case SRC_COLOR_VALUE: return SRC_COLOR;
			case ONE_MINUS_SRC_COLOR_VALUE: return ONE_MINUS_SRC_COLOR;
			case DST_COLOR_VALUE: return DST_COLOR;
			case ONE_MINUS_DST_COLOR_VALUE: return ONE_MINUS_DST_COLOR;
			case SRC_ALPHA_VALUE: return SRC_ALPHA;
			case ONE_MINUS_SRC_ALPHA_VALUE: return ONE_MINUS_SRC_ALPHA;
			case DST_ALPHA_VALUE: return DST_ALPHA;
			case ONE_MINUS_DST_ALPHA_VALUE: return ONE_MINUS_DST_ALPHA;
			case CONSTANT_COLOR_VALUE: return CONSTANT_COLOR;
			case ONE_MINUS_CONSTANT_COLOR_VALUE: return ONE_MINUS_CONSTANT_COLOR;
			case CONSTANT_ALPHA_VALUE: return CONSTANT_ALPHA;
			case ONE_MINUS_CONSTANT_ALPHA_VALUE: return ONE_MINUS_CONSTANT_ALPHA;
			case SRC_ALPHA_SATURATE_VALUE: return SRC_ALPHA_SATURATE;
			case SRC1_COLOR_VALUE: return SRC1_COLOR;
			case ONE_MINUS_SRC1_COLOR_VALUE: return ONE_MINUS_SRC1_COLOR;
			case SRC1_ALPHA_VALUE: return SRC1_ALPHA;
			case ONE_MINUS_SRC1_ALPHA_VALUE: return ONE_MINUS_SRC1_ALPHA;
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
	private EBlendFactor(int value, String name, String literal)
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
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //EBlendFactor
