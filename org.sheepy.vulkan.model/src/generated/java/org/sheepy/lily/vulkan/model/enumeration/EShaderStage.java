/**
 */
package org.sheepy.lily.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EShader Stage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.enumeration.EnumerationPackage#getEShaderStage()
 * @model
 * @generated
 */
public enum EShaderStage implements Enumerator
{
	/**
	 * The '<em><b>VERTEX BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	VERTEX_BIT(1, "VERTEX_BIT", "VERTEX_BIT"),

	/**
	 * The '<em><b>TESSELLATION CONTROL BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_CONTROL_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TESSELLATION_CONTROL_BIT(2, "TESSELLATION_CONTROL_BIT", "TESSELLATION_CONTROL_BIT"),

	/**
	 * The '<em><b>TESSELLATION EVALUATION BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_EVALUATION_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TESSELLATION_EVALUATION_BIT(4, "TESSELLATION_EVALUATION_BIT", "TESSELLATION_EVALUATION_BIT"),

	/**
	 * The '<em><b>GEOMETRY BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEOMETRY_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	GEOMETRY_BIT(8, "GEOMETRY_BIT", "GEOMETRY_BIT"),

	/**
	 * The '<em><b>FRAGMENT BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRAGMENT_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	FRAGMENT_BIT(16, "FRAGMENT_BIT", "FRAGMENT_BIT"),

	/**
	 * The '<em><b>COMPUTE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTE_BIT(32, "COMPUTE_BIT", "COMPUTE_BIT"),

	/**
	 * The '<em><b>ALL GRAPHICS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_GRAPHICS_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_GRAPHICS(31, "ALL_GRAPHICS", "ALL_GRAPHICS"),

	/**
	 * The '<em><b>ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(2147483647, "ALL", "ALL");

	/**
	 * The '<em><b>VERTEX BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERTEX_BIT_VALUE = 1;

	/**
	 * The '<em><b>TESSELLATION CONTROL BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_CONTROL_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TESSELLATION_CONTROL_BIT_VALUE = 2;

	/**
	 * The '<em><b>TESSELLATION EVALUATION BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_EVALUATION_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TESSELLATION_EVALUATION_BIT_VALUE = 4;

	/**
	 * The '<em><b>GEOMETRY BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEOMETRY_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GEOMETRY_BIT_VALUE = 8;

	/**
	 * The '<em><b>FRAGMENT BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRAGMENT_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRAGMENT_BIT_VALUE = 16;

	/**
	 * The '<em><b>COMPUTE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTE_BIT_VALUE = 32;

	/**
	 * The '<em><b>ALL GRAPHICS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_GRAPHICS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_GRAPHICS_VALUE = 31;

	/**
	 * The '<em><b>ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 2147483647;

	/**
	 * An array of all the '<em><b>EShader Stage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EShaderStage[] VALUES_ARRAY = new EShaderStage[] {
			VERTEX_BIT,
			TESSELLATION_CONTROL_BIT,
			TESSELLATION_EVALUATION_BIT,
			GEOMETRY_BIT,
			FRAGMENT_BIT,
			COMPUTE_BIT,
			ALL_GRAPHICS,
			ALL,
	};

	/**
	 * A public read-only list of all the '<em><b>EShader Stage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EShaderStage> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EShader Stage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EShaderStage get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EShaderStage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EShader Stage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EShaderStage getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EShaderStage result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EShader Stage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EShaderStage get(int value)
	{
		switch (value)
		{
		case VERTEX_BIT_VALUE:
			return VERTEX_BIT;
		case TESSELLATION_CONTROL_BIT_VALUE:
			return TESSELLATION_CONTROL_BIT;
		case TESSELLATION_EVALUATION_BIT_VALUE:
			return TESSELLATION_EVALUATION_BIT;
		case GEOMETRY_BIT_VALUE:
			return GEOMETRY_BIT;
		case FRAGMENT_BIT_VALUE:
			return FRAGMENT_BIT;
		case COMPUTE_BIT_VALUE:
			return COMPUTE_BIT;
		case ALL_GRAPHICS_VALUE:
			return ALL_GRAPHICS;
		case ALL_VALUE:
			return ALL;
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
	private EShaderStage(int value, String name, String literal)
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

} //EShaderStage
