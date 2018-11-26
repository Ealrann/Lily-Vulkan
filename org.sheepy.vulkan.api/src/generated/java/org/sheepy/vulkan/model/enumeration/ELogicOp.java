/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ELogic Op</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getELogicOp()
 * @model
 * @generated
 */
public enum ELogicOp implements Enumerator
{
	/**
	 * The '<em><b>CLEAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLEAR_VALUE
	 * @generated
	 * @ordered
	 */
	CLEAR(0, "CLEAR", "CLEAR"),

	/**
	 * The '<em><b>AND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_VALUE
	 * @generated
	 * @ordered
	 */
	AND(1, "AND", "AND"),

	/**
	 * The '<em><b>AND REVERSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_REVERSE_VALUE
	 * @generated
	 * @ordered
	 */
	AND_REVERSE(2, "AND_REVERSE", "AND_REVERSE"),

	/**
	 * The '<em><b>COPY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPY_VALUE
	 * @generated
	 * @ordered
	 */
	COPY(3, "COPY", "COPY"),

	/**
	 * The '<em><b>AND INVERTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_INVERTED_VALUE
	 * @generated
	 * @ordered
	 */
	AND_INVERTED(4, "AND_INVERTED", "AND_INVERTED"),

	/**
	 * The '<em><b>NO OP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_OP_VALUE
	 * @generated
	 * @ordered
	 */
	NO_OP(5, "NO_OP", "NO_OP"),

	/**
	 * The '<em><b>XOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XOR_VALUE
	 * @generated
	 * @ordered
	 */
	XOR(6, "XOR", "XOR"),

	/**
	 * The '<em><b>OR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_VALUE
	 * @generated
	 * @ordered
	 */
	OR(7, "OR", "OR"),

	/**
	 * The '<em><b>NOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOR_VALUE
	 * @generated
	 * @ordered
	 */
	NOR(8, "NOR", "NOR"),

	/**
	 * The '<em><b>EQUIVALENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUIVALENT_VALUE
	 * @generated
	 * @ordered
	 */
	EQUIVALENT(9, "EQUIVALENT", "EQUIVALENT"),

	/**
	 * The '<em><b>INVERT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVERT_VALUE
	 * @generated
	 * @ordered
	 */
	INVERT(10, "INVERT", "INVERT"),

	/**
	 * The '<em><b>OR REVERSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_REVERSE_VALUE
	 * @generated
	 * @ordered
	 */
	OR_REVERSE(11, "OR_REVERSE", "OR_REVERSE"),

	/**
	 * The '<em><b>COPY INVERTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPY_INVERTED_VALUE
	 * @generated
	 * @ordered
	 */
	COPY_INVERTED(12, "COPY_INVERTED", "COPY_INVERTED"),

	/**
	 * The '<em><b>OR INVERTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_INVERTED_VALUE
	 * @generated
	 * @ordered
	 */
	OR_INVERTED(13, "OR_INVERTED", "OR_INVERTED"),

	/**
	 * The '<em><b>NAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAND_VALUE
	 * @generated
	 * @ordered
	 */
	NAND(14, "NAND", "NAND"),

	/**
	 * The '<em><b>SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_VALUE
	 * @generated
	 * @ordered
	 */
	SET(15, "SET", "SET");

	/**
	 * The '<em><b>CLEAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLEAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLEAR_VALUE = 0;

	/**
	 * The '<em><b>AND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AND_VALUE = 1;

	/**
	 * The '<em><b>AND REVERSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND REVERSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND_REVERSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AND_REVERSE_VALUE = 2;

	/**
	 * The '<em><b>COPY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COPY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COPY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COPY_VALUE = 3;

	/**
	 * The '<em><b>AND INVERTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND INVERTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND_INVERTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AND_INVERTED_VALUE = 4;

	/**
	 * The '<em><b>NO OP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NO OP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_OP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NO_OP_VALUE = 5;

	/**
	 * The '<em><b>XOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XOR_VALUE = 6;

	/**
	 * The '<em><b>OR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OR_VALUE = 7;

	/**
	 * The '<em><b>NOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOR_VALUE = 8;

	/**
	 * The '<em><b>EQUIVALENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUIVALENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUIVALENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUIVALENT_VALUE = 9;

	/**
	 * The '<em><b>INVERT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INVERT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INVERT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVERT_VALUE = 10;

	/**
	 * The '<em><b>OR REVERSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR REVERSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR_REVERSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OR_REVERSE_VALUE = 11;

	/**
	 * The '<em><b>COPY INVERTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COPY INVERTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COPY_INVERTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COPY_INVERTED_VALUE = 12;

	/**
	 * The '<em><b>OR INVERTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR INVERTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR_INVERTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OR_INVERTED_VALUE = 13;

	/**
	 * The '<em><b>NAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAND_VALUE = 14;

	/**
	 * The '<em><b>SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET_VALUE = 15;

	/**
	 * An array of all the '<em><b>ELogic Op</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ELogicOp[] VALUES_ARRAY =
		new ELogicOp[]
		{
			CLEAR,
			AND,
			AND_REVERSE,
			COPY,
			AND_INVERTED,
			NO_OP,
			XOR,
			OR,
			NOR,
			EQUIVALENT,
			INVERT,
			OR_REVERSE,
			COPY_INVERTED,
			OR_INVERTED,
			NAND,
			SET,
		};

	/**
	 * A public read-only list of all the '<em><b>ELogic Op</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ELogicOp> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ELogic Op</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ELogicOp get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ELogicOp result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ELogic Op</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ELogicOp getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ELogicOp result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ELogic Op</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ELogicOp get(int value)
	{
		switch (value)
		{
			case CLEAR_VALUE: return CLEAR;
			case AND_VALUE: return AND;
			case AND_REVERSE_VALUE: return AND_REVERSE;
			case COPY_VALUE: return COPY;
			case AND_INVERTED_VALUE: return AND_INVERTED;
			case NO_OP_VALUE: return NO_OP;
			case XOR_VALUE: return XOR;
			case OR_VALUE: return OR;
			case NOR_VALUE: return NOR;
			case EQUIVALENT_VALUE: return EQUIVALENT;
			case INVERT_VALUE: return INVERT;
			case OR_REVERSE_VALUE: return OR_REVERSE;
			case COPY_INVERTED_VALUE: return COPY_INVERTED;
			case OR_INVERTED_VALUE: return OR_INVERTED;
			case NAND_VALUE: return NAND;
			case SET_VALUE: return SET;
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
	private ELogicOp(int value, String name, String literal)
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
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //ELogicOp
