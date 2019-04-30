/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ECommand Stage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getECommandStage()
 * @model
 * @generated
 */
public enum ECommandStage implements Enumerator
{
	/**
	 * The '<em><b>Transfer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER(0, "Transfer", "Transfer"),
	/**
	* The '<em><b>Compute</b></em>' literal object.
	* <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @see #COMPUTE_VALUE
	* @generated
	* @ordered
	*/
	COMPUTE(1, "Compute", "Compute"),

	/**
	 * The '<em><b>Pre Render</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRE_RENDER_VALUE
	 * @generated
	 * @ordered
	 */
	PRE_RENDER(2, "PreRender", "PreRender"),

	/**
	 * The '<em><b>Render</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENDER_VALUE
	 * @generated
	 * @ordered
	 */
	RENDER(3, "Render", "Render"),

	/**
	 * The '<em><b>Post Render</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_RENDER_VALUE
	 * @generated
	 * @ordered
	 */
	POST_RENDER(4, "PostRender", "PostRender");

	/**
	 * The '<em><b>Transfer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER
	 * @model name="Transfer"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_VALUE = 0;

	/**
	 * The '<em><b>Compute</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTE
	 * @model name="Compute"
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTE_VALUE = 1;

	/**
	 * The '<em><b>Pre Render</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRE_RENDER
	 * @model name="PreRender"
	 * @generated
	 * @ordered
	 */
	public static final int PRE_RENDER_VALUE = 2;

	/**
	 * The '<em><b>Render</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RENDER
	 * @model name="Render"
	 * @generated
	 * @ordered
	 */
	public static final int RENDER_VALUE = 3;

	/**
	 * The '<em><b>Post Render</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_RENDER
	 * @model name="PostRender"
	 * @generated
	 * @ordered
	 */
	public static final int POST_RENDER_VALUE = 4;

	/**
	 * An array of all the '<em><b>ECommand Stage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ECommandStage[] VALUES_ARRAY = new ECommandStage[] {
			TRANSFER, COMPUTE, PRE_RENDER, RENDER, POST_RENDER,
	};

	/**
	 * A public read-only list of all the '<em><b>ECommand Stage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ECommandStage> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ECommand Stage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ECommandStage get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ECommandStage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ECommand Stage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ECommandStage getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ECommandStage result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ECommand Stage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ECommandStage get(int value)
	{
		switch (value)
		{
		case TRANSFER_VALUE:
			return TRANSFER;
		case COMPUTE_VALUE:
			return COMPUTE;
		case PRE_RENDER_VALUE:
			return PRE_RENDER;
		case RENDER_VALUE:
			return RENDER;
		case POST_RENDER_VALUE:
			return POST_RENDER;
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
	private ECommandStage(int value, String name, String literal)
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

} //ECommandStage
