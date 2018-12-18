/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EDescriptor Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEDescriptorType()
 * @model
 * @generated
 */
public enum EDescriptorType implements Enumerator
{
	/**
	 * The '<em><b>SAMPLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAMPLER_VALUE
	 * @generated
	 * @ordered
	 */
	SAMPLER(0, "SAMPLER", "SAMPLER"),

	/**
	 * The '<em><b>COMBINED IMAGE SAMPLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMBINED_IMAGE_SAMPLER_VALUE
	 * @generated
	 * @ordered
	 */
	COMBINED_IMAGE_SAMPLER(1, "COMBINED_IMAGE_SAMPLER", "COMBINED_IMAGE_SAMPLER"),

	/**
	 * The '<em><b>SAMPLED IMAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAMPLED_IMAGE_VALUE
	 * @generated
	 * @ordered
	 */
	SAMPLED_IMAGE(2, "SAMPLED_IMAGE", "SAMPLED_IMAGE"),

	/**
	 * The '<em><b>STORAGE IMAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_IMAGE_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE_IMAGE(3, "STORAGE_IMAGE", "STORAGE_IMAGE"),

	/**
	 * The '<em><b>UNIFORM TEXEL BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_TEXEL_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	UNIFORM_TEXEL_BUFFER(4, "UNIFORM_TEXEL_BUFFER", "UNIFORM_TEXEL_BUFFER"),

	/**
	 * The '<em><b>STORAGE TEXEL BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_TEXEL_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE_TEXEL_BUFFER(5, "STORAGE_TEXEL_BUFFER", "STORAGE_TEXEL_BUFFER"),

	/**
	 * The '<em><b>UNIFORM BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	UNIFORM_BUFFER(6, "UNIFORM_BUFFER", "UNIFORM_BUFFER"),

	/**
	 * The '<em><b>STORAGE BUFFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_BUFFER_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE_BUFFER(7, "STORAGE_BUFFER", "STORAGE_BUFFER"),

	/**
	 * The '<em><b>UNIFORM BUFFER DYNAMIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_BUFFER_DYNAMIC_VALUE
	 * @generated
	 * @ordered
	 */
	UNIFORM_BUFFER_DYNAMIC(8, "UNIFORM_BUFFER_DYNAMIC", "UNIFORM_BUFFER_DYNAMIC"),

	/**
	 * The '<em><b>STORAGE BUFFER DYNAMIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_BUFFER_DYNAMIC_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE_BUFFER_DYNAMIC(9, "STORAGE_BUFFER_DYNAMIC", "STORAGE_BUFFER_DYNAMIC"),

	/**
	 * The '<em><b>INPUT ATTACHMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_ATTACHMENT_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_ATTACHMENT(10, "INPUT_ATTACHMENT", "INPUT_ATTACHMENT");

	/**
	 * The '<em><b>SAMPLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAMPLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAMPLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAMPLER_VALUE = 0;

	/**
	 * The '<em><b>COMBINED IMAGE SAMPLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMBINED IMAGE SAMPLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMBINED_IMAGE_SAMPLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMBINED_IMAGE_SAMPLER_VALUE = 1;

	/**
	 * The '<em><b>SAMPLED IMAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAMPLED IMAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAMPLED_IMAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAMPLED_IMAGE_VALUE = 2;

	/**
	 * The '<em><b>STORAGE IMAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORAGE IMAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORAGE_IMAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_IMAGE_VALUE = 3;

	/**
	 * The '<em><b>UNIFORM TEXEL BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIFORM TEXEL BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_TEXEL_BUFFER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIFORM_TEXEL_BUFFER_VALUE = 4;

	/**
	 * The '<em><b>STORAGE TEXEL BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORAGE TEXEL BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORAGE_TEXEL_BUFFER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_TEXEL_BUFFER_VALUE = 5;

	/**
	 * The '<em><b>UNIFORM BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIFORM BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_BUFFER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIFORM_BUFFER_VALUE = 6;

	/**
	 * The '<em><b>STORAGE BUFFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORAGE BUFFER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORAGE_BUFFER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_BUFFER_VALUE = 7;

	/**
	 * The '<em><b>UNIFORM BUFFER DYNAMIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIFORM BUFFER DYNAMIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_BUFFER_DYNAMIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIFORM_BUFFER_DYNAMIC_VALUE = 8;

	/**
	 * The '<em><b>STORAGE BUFFER DYNAMIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORAGE BUFFER DYNAMIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORAGE_BUFFER_DYNAMIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_BUFFER_DYNAMIC_VALUE = 9;

	/**
	 * The '<em><b>INPUT ATTACHMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT ATTACHMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_ATTACHMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_ATTACHMENT_VALUE = 10;

	/**
	 * An array of all the '<em><b>EDescriptor Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EDescriptorType[] VALUES_ARRAY =
		new EDescriptorType[]
		{
			SAMPLER,
			COMBINED_IMAGE_SAMPLER,
			SAMPLED_IMAGE,
			STORAGE_IMAGE,
			UNIFORM_TEXEL_BUFFER,
			STORAGE_TEXEL_BUFFER,
			UNIFORM_BUFFER,
			STORAGE_BUFFER,
			UNIFORM_BUFFER_DYNAMIC,
			STORAGE_BUFFER_DYNAMIC,
			INPUT_ATTACHMENT,
		};

	/**
	 * A public read-only list of all the '<em><b>EDescriptor Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EDescriptorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EDescriptor Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EDescriptorType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EDescriptorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EDescriptor Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EDescriptorType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EDescriptorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EDescriptor Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EDescriptorType get(int value)
	{
		switch (value)
		{
			case SAMPLER_VALUE: return SAMPLER;
			case COMBINED_IMAGE_SAMPLER_VALUE: return COMBINED_IMAGE_SAMPLER;
			case SAMPLED_IMAGE_VALUE: return SAMPLED_IMAGE;
			case STORAGE_IMAGE_VALUE: return STORAGE_IMAGE;
			case UNIFORM_TEXEL_BUFFER_VALUE: return UNIFORM_TEXEL_BUFFER;
			case STORAGE_TEXEL_BUFFER_VALUE: return STORAGE_TEXEL_BUFFER;
			case UNIFORM_BUFFER_VALUE: return UNIFORM_BUFFER;
			case STORAGE_BUFFER_VALUE: return STORAGE_BUFFER;
			case UNIFORM_BUFFER_DYNAMIC_VALUE: return UNIFORM_BUFFER_DYNAMIC;
			case STORAGE_BUFFER_DYNAMIC_VALUE: return STORAGE_BUFFER_DYNAMIC;
			case INPUT_ATTACHMENT_VALUE: return INPUT_ATTACHMENT;
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
	private EDescriptorType(int value, String name, String literal)
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
	
} //EDescriptorType
