/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ECamera Field</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getECameraField()
 * @model
 * @generated
 */
public enum ECameraField implements Enumerator
{
	/**
	 * The '<em><b>ZNear</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZNEAR_VALUE
	 * @generated
	 * @ordered
	 */
	ZNEAR(0, "ZNear", "ZNear"),

	/**
	 * The '<em><b>ZFar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZFAR_VALUE
	 * @generated
	 * @ordered
	 */
	ZFAR(1, "ZFar", "ZFar"),

	/**
	 * The '<em><b>Field Of View X</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELD_OF_VIEW_X_VALUE
	 * @generated
	 * @ordered
	 */
	FIELD_OF_VIEW_X(2, "FieldOfViewX", "FieldOfViewX"),

	/**
	 * The '<em><b>Field Of View Y</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELD_OF_VIEW_Y_VALUE
	 * @generated
	 * @ordered
	 */
	FIELD_OF_VIEW_Y(3, "FieldOfViewY", "FieldOfViewY");

	/**
	 * The '<em><b>ZNear</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZNEAR
	 * @model name="ZNear"
	 * @generated
	 * @ordered
	 */
	public static final int ZNEAR_VALUE = 0;

	/**
	 * The '<em><b>ZFar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZFAR
	 * @model name="ZFar"
	 * @generated
	 * @ordered
	 */
	public static final int ZFAR_VALUE = 1;

	/**
	 * The '<em><b>Field Of View X</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELD_OF_VIEW_X
	 * @model name="FieldOfViewX"
	 * @generated
	 * @ordered
	 */
	public static final int FIELD_OF_VIEW_X_VALUE = 2;

	/**
	 * The '<em><b>Field Of View Y</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELD_OF_VIEW_Y
	 * @model name="FieldOfViewY"
	 * @generated
	 * @ordered
	 */
	public static final int FIELD_OF_VIEW_Y_VALUE = 3;

	/**
	 * An array of all the '<em><b>ECamera Field</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ECameraField[] VALUES_ARRAY =
		new ECameraField[]
		{
			ZNEAR,
			ZFAR,
			FIELD_OF_VIEW_X,
			FIELD_OF_VIEW_Y,
		};

	/**
	 * A public read-only list of all the '<em><b>ECamera Field</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ECameraField> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ECamera Field</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ECameraField get(String literal)
	{
		for (ECameraField result : VALUES_ARRAY)
		{
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ECamera Field</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ECameraField getByName(String name)
	{
		for (ECameraField result : VALUES_ARRAY)
		{
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ECamera Field</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ECameraField get(int value)
	{
		switch (value)
		{
			case ZNEAR_VALUE: return ZNEAR;
			case ZFAR_VALUE: return ZFAR;
			case FIELD_OF_VIEW_X_VALUE: return FIELD_OF_VIEW_X;
			case FIELD_OF_VIEW_Y_VALUE: return FIELD_OF_VIEW_Y;
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
	private ECameraField(int value, String name, String literal)
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

} //ECameraField
