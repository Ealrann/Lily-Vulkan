/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EMemory Property</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEMemoryProperty()
 * @model
 * @generated
 */
public enum EMemoryProperty implements Enumerator
{
	/**
	 * The '<em><b>DEVICE LOCAL BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEVICE_LOCAL_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	DEVICE_LOCAL_BIT(1, "DEVICE_LOCAL_BIT", "DEVICE_LOCAL_BIT"),

	/**
	 * The '<em><b>HOST VISIBLE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_VISIBLE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	HOST_VISIBLE_BIT(2, "HOST_VISIBLE_BIT", "HOST_VISIBLE_BIT"),

	/**
	 * The '<em><b>HOST COHERENT BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_COHERENT_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	HOST_COHERENT_BIT(4, "HOST_COHERENT_BIT", "HOST_COHERENT_BIT"),

	/**
	 * The '<em><b>HOST CACHED BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_CACHED_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	HOST_CACHED_BIT(8, "HOST_CACHED_BIT", "HOST_CACHED_BIT"),

	/**
	 * The '<em><b>LAZILY ALLOCATED BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAZILY_ALLOCATED_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	LAZILY_ALLOCATED_BIT(16, "LAZILY_ALLOCATED_BIT", "LAZILY_ALLOCATED_BIT");

	/**
	 * The '<em><b>DEVICE LOCAL BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEVICE_LOCAL_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEVICE_LOCAL_BIT_VALUE = 1;

	/**
	 * The '<em><b>HOST VISIBLE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_VISIBLE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOST_VISIBLE_BIT_VALUE = 2;

	/**
	 * The '<em><b>HOST COHERENT BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_COHERENT_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOST_COHERENT_BIT_VALUE = 4;

	/**
	 * The '<em><b>HOST CACHED BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_CACHED_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOST_CACHED_BIT_VALUE = 8;

	/**
	 * The '<em><b>LAZILY ALLOCATED BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAZILY_ALLOCATED_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LAZILY_ALLOCATED_BIT_VALUE = 16;

	/**
	 * An array of all the '<em><b>EMemory Property</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EMemoryProperty[] VALUES_ARRAY = new EMemoryProperty[]
		{
			DEVICE_LOCAL_BIT,
			HOST_VISIBLE_BIT,
			HOST_COHERENT_BIT,
			HOST_CACHED_BIT,
			LAZILY_ALLOCATED_BIT,
		};

	/**
	 * A public read-only list of all the '<em><b>EMemory Property</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EMemoryProperty> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EMemory Property</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EMemoryProperty get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EMemoryProperty result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EMemory Property</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EMemoryProperty getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EMemoryProperty result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EMemory Property</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EMemoryProperty get(int value)
	{
		switch (value)
		{
			case DEVICE_LOCAL_BIT_VALUE: return DEVICE_LOCAL_BIT;
			case HOST_VISIBLE_BIT_VALUE: return HOST_VISIBLE_BIT;
			case HOST_COHERENT_BIT_VALUE: return HOST_COHERENT_BIT;
			case HOST_CACHED_BIT_VALUE: return HOST_CACHED_BIT;
			case LAZILY_ALLOCATED_BIT_VALUE: return LAZILY_ALLOCATED_BIT;
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
	private EMemoryProperty(int value, String name, String literal)
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

} //EMemoryProperty
