/**
 */
package org.sheepy.lily.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ESampler Address Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.enumeration.EnumerationPackage#getESamplerAddressMode()
 * @model
 * @generated
 */
public enum ESamplerAddressMode implements Enumerator
{
	/**
	 * The '<em><b>REPEAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPEAT_VALUE
	 * @generated
	 * @ordered
	 */
	REPEAT(0, "REPEAT", "REPEAT"),

	/**
	 * The '<em><b>MIRRORED REPEAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIRRORED_REPEAT_VALUE
	 * @generated
	 * @ordered
	 */
	MIRRORED_REPEAT(1, "MIRRORED_REPEAT", "MIRRORED_REPEAT"),

	/**
	 * The '<em><b>CLAMP TO EDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_EDGE_VALUE
	 * @generated
	 * @ordered
	 */
	CLAMP_TO_EDGE(2, "CLAMP_TO_EDGE", "CLAMP_TO_EDGE"),

	/**
	 * The '<em><b>CLAMP TO BORDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_BORDER_VALUE
	 * @generated
	 * @ordered
	 */
	CLAMP_TO_BORDER(3, "CLAMP_TO_BORDER", "CLAMP_TO_BORDER");

	/**
	 * The '<em><b>REPEAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPEAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REPEAT_VALUE = 0;

	/**
	 * The '<em><b>MIRRORED REPEAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIRRORED_REPEAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MIRRORED_REPEAT_VALUE = 1;

	/**
	 * The '<em><b>CLAMP TO EDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_EDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLAMP_TO_EDGE_VALUE = 2;

	/**
	 * The '<em><b>CLAMP TO BORDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLAMP_TO_BORDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLAMP_TO_BORDER_VALUE = 3;

	/**
	 * An array of all the '<em><b>ESampler Address Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ESamplerAddressMode[] VALUES_ARRAY = new ESamplerAddressMode[] {
			REPEAT, MIRRORED_REPEAT, CLAMP_TO_EDGE, CLAMP_TO_BORDER,
	};

	/**
	 * A public read-only list of all the '<em><b>ESampler Address Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ESamplerAddressMode> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ESampler Address Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ESamplerAddressMode get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ESamplerAddressMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ESampler Address Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ESamplerAddressMode getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ESamplerAddressMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ESampler Address Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ESamplerAddressMode get(int value)
	{
		switch (value)
		{
		case REPEAT_VALUE:
			return REPEAT;
		case MIRRORED_REPEAT_VALUE:
			return MIRRORED_REPEAT;
		case CLAMP_TO_EDGE_VALUE:
			return CLAMP_TO_EDGE;
		case CLAMP_TO_BORDER_VALUE:
			return CLAMP_TO_BORDER;
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
	private ESamplerAddressMode(int value, String name, String literal)
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

} //ESamplerAddressMode
