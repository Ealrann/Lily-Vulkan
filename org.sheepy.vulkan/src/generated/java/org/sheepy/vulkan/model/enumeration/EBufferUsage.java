/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EBuffer Usage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEBufferUsage()
 * @model
 * @generated
 */
public enum EBufferUsage implements Enumerator
{
	/**
	 * The '<em><b>TRANSFER SRC BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_SRC_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_SRC_BIT(1, "TRANSFER_SRC_BIT", "TRANSFER_SRC_BIT"),

	/**
	 * The '<em><b>TRANSFER DST BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_DST_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_DST_BIT(2, "TRANSFER_DST_BIT", "TRANSFER_DST_BIT"),

	/**
	 * The '<em><b>UNIFORM TEXEL BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_TEXEL_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	UNIFORM_TEXEL_BUFFER_BIT(4, "UNIFORM_TEXEL_BUFFER_BIT", "UNIFORM_TEXEL_BUFFER_BIT"),

	/**
	 * The '<em><b>STORAGE TEXEL BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_TEXEL_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE_TEXEL_BUFFER_BIT(8, "STORAGE_TEXEL_BUFFER_BIT", "STORAGE_TEXEL_BUFFER_BIT"),

	/**
	 * The '<em><b>UNIFORM BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	UNIFORM_BUFFER_BIT(16, "UNIFORM_BUFFER_BIT", "UNIFORM_BUFFER_BIT"),

	/**
	 * The '<em><b>STORAGE BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE_BUFFER_BIT(32, "STORAGE_BUFFER_BIT", "STORAGE_BUFFER_BIT"),

	/**
	 * The '<em><b>INDEX BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDEX_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	INDEX_BUFFER_BIT(64, "INDEX_BUFFER_BIT", "INDEX_BUFFER_BIT"),

	/**
	 * The '<em><b>VERTEX BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	VERTEX_BUFFER_BIT(128, "VERTEX_BUFFER_BIT", "VERTEX_BUFFER_BIT"),

	/**
	 * The '<em><b>INDIRECT BUFFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_BUFFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECT_BUFFER_BIT(256, "INDIRECT_BUFFER_BIT", "INDIRECT_BUFFER_BIT");

	/**
	 * The '<em><b>TRANSFER SRC BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_SRC_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_SRC_BIT_VALUE = 1;

	/**
	 * The '<em><b>TRANSFER DST BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_DST_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_DST_BIT_VALUE = 2;

	/**
	 * The '<em><b>UNIFORM TEXEL BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_TEXEL_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIFORM_TEXEL_BUFFER_BIT_VALUE = 4;

	/**
	 * The '<em><b>STORAGE TEXEL BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_TEXEL_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_TEXEL_BUFFER_BIT_VALUE = 8;

	/**
	 * The '<em><b>UNIFORM BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIFORM_BUFFER_BIT_VALUE = 16;

	/**
	 * The '<em><b>STORAGE BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_BUFFER_BIT_VALUE = 32;

	/**
	 * The '<em><b>INDEX BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDEX_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDEX_BUFFER_BIT_VALUE = 64;

	/**
	 * The '<em><b>VERTEX BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERTEX_BUFFER_BIT_VALUE = 128;

	/**
	 * The '<em><b>INDIRECT BUFFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_BUFFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECT_BUFFER_BIT_VALUE = 256;

	/**
	 * An array of all the '<em><b>EBuffer Usage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EBufferUsage[] VALUES_ARRAY = new EBufferUsage[] {
			TRANSFER_SRC_BIT,
			TRANSFER_DST_BIT,
			UNIFORM_TEXEL_BUFFER_BIT,
			STORAGE_TEXEL_BUFFER_BIT,
			UNIFORM_BUFFER_BIT,
			STORAGE_BUFFER_BIT,
			INDEX_BUFFER_BIT,
			VERTEX_BUFFER_BIT,
			INDIRECT_BUFFER_BIT,
	};

	/**
	 * A public read-only list of all the '<em><b>EBuffer Usage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EBufferUsage> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EBuffer Usage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBufferUsage get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EBufferUsage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EBuffer Usage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBufferUsage getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EBufferUsage result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EBuffer Usage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EBufferUsage get(int value)
	{
		switch (value)
		{
		case TRANSFER_SRC_BIT_VALUE:
			return TRANSFER_SRC_BIT;
		case TRANSFER_DST_BIT_VALUE:
			return TRANSFER_DST_BIT;
		case UNIFORM_TEXEL_BUFFER_BIT_VALUE:
			return UNIFORM_TEXEL_BUFFER_BIT;
		case STORAGE_TEXEL_BUFFER_BIT_VALUE:
			return STORAGE_TEXEL_BUFFER_BIT;
		case UNIFORM_BUFFER_BIT_VALUE:
			return UNIFORM_BUFFER_BIT;
		case STORAGE_BUFFER_BIT_VALUE:
			return STORAGE_BUFFER_BIT;
		case INDEX_BUFFER_BIT_VALUE:
			return INDEX_BUFFER_BIT;
		case VERTEX_BUFFER_BIT_VALUE:
			return VERTEX_BUFFER_BIT;
		case INDIRECT_BUFFER_BIT_VALUE:
			return INDIRECT_BUFFER_BIT;
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
	private EBufferUsage(int value, String name, String literal)
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

} //EBufferUsage
