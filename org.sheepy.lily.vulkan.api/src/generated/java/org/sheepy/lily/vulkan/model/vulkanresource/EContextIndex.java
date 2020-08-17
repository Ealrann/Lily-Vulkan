/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EContext Index</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getEContextIndex()
 * @model
 * @generated
 */
public enum EContextIndex implements Enumerator
{
	/**
	 * The '<em><b>Context Instance</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_INSTANCE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTEXT_INSTANCE(0, "ContextInstance", "ContextInstance"),

	/**
	 * The '<em><b>Context Instance Plus One</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_INSTANCE_PLUS_ONE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTEXT_INSTANCE_PLUS_ONE(1, "ContextInstance_PlusOne", "ContextInstance_PlusOne"),

	/**
	 * The '<em><b>Context Instance Minus One</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_INSTANCE_MINUS_ONE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTEXT_INSTANCE_MINUS_ONE(2, "ContextInstance_MinusOne", "ContextInstance_MinusOne");

	/**
	 * The '<em><b>Context Instance</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_INSTANCE
	 * @model name="ContextInstance"
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_INSTANCE_VALUE = 0;

	/**
	 * The '<em><b>Context Instance Plus One</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_INSTANCE_PLUS_ONE
	 * @model name="ContextInstance_PlusOne"
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_INSTANCE_PLUS_ONE_VALUE = 1;

	/**
	 * The '<em><b>Context Instance Minus One</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTEXT_INSTANCE_MINUS_ONE
	 * @model name="ContextInstance_MinusOne"
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_INSTANCE_MINUS_ONE_VALUE = 2;

	/**
	 * An array of all the '<em><b>EContext Index</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EContextIndex[] VALUES_ARRAY =
		new EContextIndex[]
		{
			CONTEXT_INSTANCE,
			CONTEXT_INSTANCE_PLUS_ONE,
			CONTEXT_INSTANCE_MINUS_ONE,
		};

	/**
	 * A public read-only list of all the '<em><b>EContext Index</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EContextIndex> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EContext Index</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EContextIndex get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EContextIndex result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EContext Index</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EContextIndex getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EContextIndex result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EContext Index</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EContextIndex get(int value)
	{
		switch (value)
		{
			case CONTEXT_INSTANCE_VALUE: return CONTEXT_INSTANCE;
			case CONTEXT_INSTANCE_PLUS_ONE_VALUE: return CONTEXT_INSTANCE_PLUS_ONE;
			case CONTEXT_INSTANCE_MINUS_ONE_VALUE: return CONTEXT_INSTANCE_MINUS_ONE;
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
	private EContextIndex(int value, String name, String literal)
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
	
} //EContextIndex
