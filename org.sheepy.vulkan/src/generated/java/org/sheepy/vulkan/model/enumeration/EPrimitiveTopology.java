/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EPrimitive Topology</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEPrimitiveTopology()
 * @model
 * @generated
 */
public enum EPrimitiveTopology implements Enumerator
{
	/**
	 * The '<em><b>POINT LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINT_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	POINT_LIST(0, "POINT_LIST", "POINT_LIST"),

	/**
	 * The '<em><b>LINE LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	LINE_LIST(1, "LINE_LIST", "LINE_LIST"),

	/**
	 * The '<em><b>LINE STRIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_STRIP_VALUE
	 * @generated
	 * @ordered
	 */
	LINE_STRIP(2, "LINE_STRIP", "LINE_STRIP"),

	/**
	 * The '<em><b>TRIANGLE LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE_LIST(3, "TRIANGLE_LIST", "TRIANGLE_LIST"),

	/**
	 * The '<em><b>TRIANGLE STRIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_STRIP_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE_STRIP(4, "TRIANGLE_STRIP", "TRIANGLE_STRIP"),

	/**
	 * The '<em><b>TRIANGLE FAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_FAN_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE_FAN(5, "TRIANGLE_FAN", "TRIANGLE_FAN"),

	/**
	 * The '<em><b>LINE LIST WITH ADJACENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_LIST_WITH_ADJACENCY_VALUE
	 * @generated
	 * @ordered
	 */
	LINE_LIST_WITH_ADJACENCY(6, "LINE_LIST_WITH_ADJACENCY", "LINE_LIST_WITH_ADJACENCY"),

	/**
	 * The '<em><b>LINE STRIP WITH ADJACENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_STRIP_WITH_ADJACENCY_VALUE
	 * @generated
	 * @ordered
	 */
	LINE_STRIP_WITH_ADJACENCY(7, "LINE_STRIP_WITH_ADJACENCY", "LINE_STRIP_WITH_ADJACENCY"),

	/**
	 * The '<em><b>TRIANGLE LIST WITH ADJACENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_LIST_WITH_ADJACENCY_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE_LIST_WITH_ADJACENCY(8, "TRIANGLE_LIST_WITH_ADJACENCY", "TRIANGLE_LIST_WITH_ADJACENCY"),

	/**
	 * The '<em><b>TRIANGLE STRIP WITH ADJACENCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_STRIP_WITH_ADJACENCY_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE_STRIP_WITH_ADJACENCY(
			9,
			"TRIANGLE_STRIP_WITH_ADJACENCY",
			"TRIANGLE_STRIP_WITH_ADJACENCY"),

	/**
	 * The '<em><b>PATCH LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATCH_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	PATCH_LIST(10, "PATCH_LIST", "PATCH_LIST");

	/**
	 * The '<em><b>POINT LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINT_LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POINT_LIST_VALUE = 0;

	/**
	 * The '<em><b>LINE LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_LIST_VALUE = 1;

	/**
	 * The '<em><b>LINE STRIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_STRIP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_STRIP_VALUE = 2;

	/**
	 * The '<em><b>TRIANGLE LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_LIST_VALUE = 3;

	/**
	 * The '<em><b>TRIANGLE STRIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_STRIP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_STRIP_VALUE = 4;

	/**
	 * The '<em><b>TRIANGLE FAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_FAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_FAN_VALUE = 5;

	/**
	 * The '<em><b>LINE LIST WITH ADJACENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_LIST_WITH_ADJACENCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_LIST_WITH_ADJACENCY_VALUE = 6;

	/**
	 * The '<em><b>LINE STRIP WITH ADJACENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_STRIP_WITH_ADJACENCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_STRIP_WITH_ADJACENCY_VALUE = 7;

	/**
	 * The '<em><b>TRIANGLE LIST WITH ADJACENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_LIST_WITH_ADJACENCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_LIST_WITH_ADJACENCY_VALUE = 8;

	/**
	 * The '<em><b>TRIANGLE STRIP WITH ADJACENCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_STRIP_WITH_ADJACENCY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_STRIP_WITH_ADJACENCY_VALUE = 9;

	/**
	 * The '<em><b>PATCH LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PATCH_LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PATCH_LIST_VALUE = 10;

	/**
	 * An array of all the '<em><b>EPrimitive Topology</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EPrimitiveTopology[] VALUES_ARRAY = new EPrimitiveTopology[] {
			POINT_LIST,
			LINE_LIST,
			LINE_STRIP,
			TRIANGLE_LIST,
			TRIANGLE_STRIP,
			TRIANGLE_FAN,
			LINE_LIST_WITH_ADJACENCY,
			LINE_STRIP_WITH_ADJACENCY,
			TRIANGLE_LIST_WITH_ADJACENCY,
			TRIANGLE_STRIP_WITH_ADJACENCY,
			PATCH_LIST,
	};

	/**
	 * A public read-only list of all the '<em><b>EPrimitive Topology</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EPrimitiveTopology> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EPrimitive Topology</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPrimitiveTopology get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EPrimitiveTopology result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EPrimitive Topology</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPrimitiveTopology getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EPrimitiveTopology result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EPrimitive Topology</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPrimitiveTopology get(int value)
	{
		switch (value)
		{
		case POINT_LIST_VALUE:
			return POINT_LIST;
		case LINE_LIST_VALUE:
			return LINE_LIST;
		case LINE_STRIP_VALUE:
			return LINE_STRIP;
		case TRIANGLE_LIST_VALUE:
			return TRIANGLE_LIST;
		case TRIANGLE_STRIP_VALUE:
			return TRIANGLE_STRIP;
		case TRIANGLE_FAN_VALUE:
			return TRIANGLE_FAN;
		case LINE_LIST_WITH_ADJACENCY_VALUE:
			return LINE_LIST_WITH_ADJACENCY;
		case LINE_STRIP_WITH_ADJACENCY_VALUE:
			return LINE_STRIP_WITH_ADJACENCY;
		case TRIANGLE_LIST_WITH_ADJACENCY_VALUE:
			return TRIANGLE_LIST_WITH_ADJACENCY;
		case TRIANGLE_STRIP_WITH_ADJACENCY_VALUE:
			return TRIANGLE_STRIP_WITH_ADJACENCY;
		case PATCH_LIST_VALUE:
			return PATCH_LIST;
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
	private EPrimitiveTopology(int value, String name, String literal)
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

} //EPrimitiveTopology
