/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EImage Layout</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEImageLayout()
 * @model
 * @generated
 */
public enum EImageLayout implements Enumerator
{
	/**
	 * The '<em><b>UNDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(0, "UNDEFINED", "UNDEFINED"),

	/**
	 * The '<em><b>GENERAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERAL_VALUE
	 * @generated
	 * @ordered
	 */
	GENERAL(1, "GENERAL", "GENERAL"),

	/**
	 * The '<em><b>COLOR ATTACHMENT OPTIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_OPTIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR_ATTACHMENT_OPTIMAL(2, "COLOR_ATTACHMENT_OPTIMAL", "COLOR_ATTACHMENT_OPTIMAL"),

	/**
	 * The '<em><b>DEPTH STENCIL ATTACHMENT OPTIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_OPTIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_STENCIL_ATTACHMENT_OPTIMAL(3, "DEPTH_STENCIL_ATTACHMENT_OPTIMAL", "DEPTH_STENCIL_ATTACHMENT_OPTIMAL"),

	/**
	 * The '<em><b>DEPTH STENCIL READ ONLY OPTIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_READ_ONLY_OPTIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_STENCIL_READ_ONLY_OPTIMAL(4, "DEPTH_STENCIL_READ_ONLY_OPTIMAL", "DEPTH_STENCIL_READ_ONLY_OPTIMAL"),

	/**
	 * The '<em><b>SHADER READ ONLY OPTIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADER_READ_ONLY_OPTIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	SHADER_READ_ONLY_OPTIMAL(5, "SHADER_READ_ONLY_OPTIMAL", "SHADER_READ_ONLY_OPTIMAL"),

	/**
	 * The '<em><b>TRANSFER SRC OPTIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_SRC_OPTIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_SRC_OPTIMAL(6, "TRANSFER_SRC_OPTIMAL", "TRANSFER_SRC_OPTIMAL"),

	/**
	 * The '<em><b>TRANSFER DST OPTIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_DST_OPTIMAL_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_DST_OPTIMAL(7, "TRANSFER_DST_OPTIMAL", "TRANSFER_DST_OPTIMAL"),

	/**
	 * The '<em><b>PREINITIALIZED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREINITIALIZED_VALUE
	 * @generated
	 * @ordered
	 */
	PREINITIALIZED(8, "PREINITIALIZED", "PREINITIALIZED"),

	/**
	 * The '<em><b>PRESENT SRC KHR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESENT_SRC_KHR_VALUE
	 * @generated
	 * @ordered
	 */
	PRESENT_SRC_KHR(1000001002, "PRESENT_SRC_KHR", "PRESENT_SRC_KHR");

	/**
	 * The '<em><b>UNDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 0;

	/**
	 * The '<em><b>GENERAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERAL_VALUE = 1;

	/**
	 * The '<em><b>COLOR ATTACHMENT OPTIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_OPTIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_ATTACHMENT_OPTIMAL_VALUE = 2;

	/**
	 * The '<em><b>DEPTH STENCIL ATTACHMENT OPTIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_OPTIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_STENCIL_ATTACHMENT_OPTIMAL_VALUE = 3;

	/**
	 * The '<em><b>DEPTH STENCIL READ ONLY OPTIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_READ_ONLY_OPTIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_STENCIL_READ_ONLY_OPTIMAL_VALUE = 4;

	/**
	 * The '<em><b>SHADER READ ONLY OPTIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADER_READ_ONLY_OPTIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHADER_READ_ONLY_OPTIMAL_VALUE = 5;

	/**
	 * The '<em><b>TRANSFER SRC OPTIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_SRC_OPTIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_SRC_OPTIMAL_VALUE = 6;

	/**
	 * The '<em><b>TRANSFER DST OPTIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_DST_OPTIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_DST_OPTIMAL_VALUE = 7;

	/**
	 * The '<em><b>PREINITIALIZED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREINITIALIZED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PREINITIALIZED_VALUE = 8;

	/**
	 * The '<em><b>PRESENT SRC KHR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESENT_SRC_KHR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESENT_SRC_KHR_VALUE = 1000001002;

	/**
	 * An array of all the '<em><b>EImage Layout</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EImageLayout[] VALUES_ARRAY = new EImageLayout[]
		{
			UNDEFINED,
			GENERAL,
			COLOR_ATTACHMENT_OPTIMAL,
			DEPTH_STENCIL_ATTACHMENT_OPTIMAL,
			DEPTH_STENCIL_READ_ONLY_OPTIMAL,
			SHADER_READ_ONLY_OPTIMAL,
			TRANSFER_SRC_OPTIMAL,
			TRANSFER_DST_OPTIMAL,
			PREINITIALIZED,
			PRESENT_SRC_KHR,
		};

	/**
	 * A public read-only list of all the '<em><b>EImage Layout</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EImageLayout> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EImage Layout</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EImageLayout get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EImageLayout result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EImage Layout</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EImageLayout getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EImageLayout result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EImage Layout</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EImageLayout get(int value)
	{
		switch (value)
		{
			case UNDEFINED_VALUE: return UNDEFINED;
			case GENERAL_VALUE: return GENERAL;
			case COLOR_ATTACHMENT_OPTIMAL_VALUE: return COLOR_ATTACHMENT_OPTIMAL;
			case DEPTH_STENCIL_ATTACHMENT_OPTIMAL_VALUE: return DEPTH_STENCIL_ATTACHMENT_OPTIMAL;
			case DEPTH_STENCIL_READ_ONLY_OPTIMAL_VALUE: return DEPTH_STENCIL_READ_ONLY_OPTIMAL;
			case SHADER_READ_ONLY_OPTIMAL_VALUE: return SHADER_READ_ONLY_OPTIMAL;
			case TRANSFER_SRC_OPTIMAL_VALUE: return TRANSFER_SRC_OPTIMAL;
			case TRANSFER_DST_OPTIMAL_VALUE: return TRANSFER_DST_OPTIMAL;
			case PREINITIALIZED_VALUE: return PREINITIALIZED;
			case PRESENT_SRC_KHR_VALUE: return PRESENT_SRC_KHR;
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
	private EImageLayout(int value, String name, String literal)
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

} //EImageLayout
