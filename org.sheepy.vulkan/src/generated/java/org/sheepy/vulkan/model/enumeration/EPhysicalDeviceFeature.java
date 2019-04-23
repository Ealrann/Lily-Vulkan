/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EPhysical Device Feature</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEPhysicalDeviceFeature()
 * @model
 * @generated
 */
public enum EPhysicalDeviceFeature implements Enumerator
{
	/**
	 * The '<em><b>GEOMETRY SHADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEOMETRY_SHADER_VALUE
	 * @generated
	 * @ordered
	 */
	GEOMETRY_SHADER(0, "GEOMETRY_SHADER", "GEOMETRY_SHADER"),

	/**
	 * The '<em><b>FILL MODE NON SOLID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILL_MODE_NON_SOLID_VALUE
	 * @generated
	 * @ordered
	 */
	FILL_MODE_NON_SOLID(0, "FILL_MODE_NON_SOLID", "FILL_MODE_NON_SOLID"),

	/**
	 * The '<em><b>WIDE LINES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDE_LINES_VALUE
	 * @generated
	 * @ordered
	 */
	WIDE_LINES(0, "WIDE_LINES", "WIDE_LINES");

	/**
	 * The '<em><b>GEOMETRY SHADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEOMETRY_SHADER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GEOMETRY_SHADER_VALUE = 0;

	/**
	 * The '<em><b>FILL MODE NON SOLID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILL_MODE_NON_SOLID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FILL_MODE_NON_SOLID_VALUE = 0;

	/**
	 * The '<em><b>WIDE LINES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDE_LINES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIDE_LINES_VALUE = 0;

	/**
	 * An array of all the '<em><b>EPhysical Device Feature</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EPhysicalDeviceFeature[] VALUES_ARRAY = new EPhysicalDeviceFeature[] {
			GEOMETRY_SHADER, FILL_MODE_NON_SOLID, WIDE_LINES,
	};

	/**
	 * A public read-only list of all the '<em><b>EPhysical Device Feature</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EPhysicalDeviceFeature> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EPhysical Device Feature</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPhysicalDeviceFeature get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EPhysicalDeviceFeature result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EPhysical Device Feature</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPhysicalDeviceFeature getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EPhysicalDeviceFeature result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EPhysical Device Feature</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPhysicalDeviceFeature get(int value)
	{
		switch (value)
		{
		case GEOMETRY_SHADER_VALUE:
			return GEOMETRY_SHADER;
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
	private EPhysicalDeviceFeature(int value, String name, String literal)
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

} //EPhysicalDeviceFeature
