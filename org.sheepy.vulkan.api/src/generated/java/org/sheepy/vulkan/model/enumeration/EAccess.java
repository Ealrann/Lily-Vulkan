/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EAccess</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEAccess()
 * @model
 * @generated
 */
public enum EAccess implements Enumerator
{
	/**
	 * The '<em><b>INDIRECT COMMAND READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_COMMAND_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	INDIRECT_COMMAND_READ_BIT(1, "INDIRECT_COMMAND_READ_BIT", "INDIRECT_COMMAND_READ_BIT"),

	/**
	 * The '<em><b>INDEX READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDEX_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	INDEX_READ_BIT(2, "INDEX_READ_BIT", "INDEX_READ_BIT"),

	/**
	 * The '<em><b>VERTEX ATTRIBUTE READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_ATTRIBUTE_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	VERTEX_ATTRIBUTE_READ_BIT(4, "VERTEX_ATTRIBUTE_READ_BIT", "VERTEX_ATTRIBUTE_READ_BIT"),

	/**
	 * The '<em><b>UNIFORM READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	UNIFORM_READ_BIT(8, "UNIFORM_READ_BIT", "UNIFORM_READ_BIT"),

	/**
	 * The '<em><b>INPUT ATTACHMENT READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_ATTACHMENT_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_ATTACHMENT_READ_BIT(16, "INPUT_ATTACHMENT_READ_BIT", "INPUT_ATTACHMENT_READ_BIT"),

	/**
	 * The '<em><b>SHADER READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADER_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	SHADER_READ_BIT(32, "SHADER_READ_BIT", "SHADER_READ_BIT"),

	/**
	 * The '<em><b>SHADER WRITE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADER_WRITE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	SHADER_WRITE_BIT(64, "SHADER_WRITE_BIT", "SHADER_WRITE_BIT"),

	/**
	 * The '<em><b>COLOR ATTACHMENT READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR_ATTACHMENT_READ_BIT(128, "COLOR_ATTACHMENT_READ_BIT", "COLOR_ATTACHMENT_READ_BIT"),

	/**
	 * The '<em><b>COLOR ATTACHMENT WRITE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_WRITE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR_ATTACHMENT_WRITE_BIT(256, "COLOR_ATTACHMENT_WRITE_BIT", "COLOR_ATTACHMENT_WRITE_BIT"),

	/**
	 * The '<em><b>DEPTH STENCIL ATTACHMENT READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_STENCIL_ATTACHMENT_READ_BIT(512, "DEPTH_STENCIL_ATTACHMENT_READ_BIT", "DEPTH_STENCIL_ATTACHMENT_READ_BIT"),

	/**
	 * The '<em><b>DEPTH STENCIL ATTACHMENT WRITE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_WRITE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_STENCIL_ATTACHMENT_WRITE_BIT(1024, "DEPTH_STENCIL_ATTACHMENT_WRITE_BIT", "DEPTH_STENCIL_ATTACHMENT_WRITE_BIT"),

	/**
	 * The '<em><b>TRANSFER READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_READ_BIT(2048, "TRANSFER_READ_BIT", "TRANSFER_READ_BIT"),

	/**
	 * The '<em><b>TRANSFER WRITE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_WRITE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_WRITE_BIT(4096, "TRANSFER_WRITE_BIT", "TRANSFER_WRITE_BIT"),

	/**
	 * The '<em><b>HOST READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	HOST_READ_BIT(8192, "HOST_READ_BIT", "HOST_READ_BIT"),

	/**
	 * The '<em><b>HOST WRITE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_WRITE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	HOST_WRITE_BIT(16384, "HOST_WRITE_BIT", "HOST_WRITE_BIT"),

	/**
	 * The '<em><b>MEMORY READ BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_READ_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY_READ_BIT(32768, "MEMORY_READ_BIT", "MEMORY_READ_BIT"),

	/**
	 * The '<em><b>MEMORY WRITE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_WRITE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY_WRITE_BIT(65536, "MEMORY_WRITE_BIT", "MEMORY_WRITE_BIT");

	/**
	 * The '<em><b>INDIRECT COMMAND READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECT COMMAND READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECT_COMMAND_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECT_COMMAND_READ_BIT_VALUE = 1;

	/**
	 * The '<em><b>INDEX READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDEX READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDEX_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDEX_READ_BIT_VALUE = 2;

	/**
	 * The '<em><b>VERTEX ATTRIBUTE READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERTEX ATTRIBUTE READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERTEX_ATTRIBUTE_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERTEX_ATTRIBUTE_READ_BIT_VALUE = 4;

	/**
	 * The '<em><b>UNIFORM READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIFORM READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIFORM_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIFORM_READ_BIT_VALUE = 8;

	/**
	 * The '<em><b>INPUT ATTACHMENT READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPUT ATTACHMENT READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_ATTACHMENT_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_ATTACHMENT_READ_BIT_VALUE = 16;

	/**
	 * The '<em><b>SHADER READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHADER READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHADER_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHADER_READ_BIT_VALUE = 32;

	/**
	 * The '<em><b>SHADER WRITE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHADER WRITE BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHADER_WRITE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHADER_WRITE_BIT_VALUE = 64;

	/**
	 * The '<em><b>COLOR ATTACHMENT READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLOR ATTACHMENT READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_ATTACHMENT_READ_BIT_VALUE = 128;

	/**
	 * The '<em><b>COLOR ATTACHMENT WRITE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLOR ATTACHMENT WRITE BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_WRITE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_ATTACHMENT_WRITE_BIT_VALUE = 256;

	/**
	 * The '<em><b>DEPTH STENCIL ATTACHMENT READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEPTH STENCIL ATTACHMENT READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_STENCIL_ATTACHMENT_READ_BIT_VALUE = 512;

	/**
	 * The '<em><b>DEPTH STENCIL ATTACHMENT WRITE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEPTH STENCIL ATTACHMENT WRITE BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_WRITE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_STENCIL_ATTACHMENT_WRITE_BIT_VALUE = 1024;

	/**
	 * The '<em><b>TRANSFER READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSFER READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_READ_BIT_VALUE = 2048;

	/**
	 * The '<em><b>TRANSFER WRITE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSFER WRITE BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_WRITE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_WRITE_BIT_VALUE = 4096;

	/**
	 * The '<em><b>HOST READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HOST READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOST_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOST_READ_BIT_VALUE = 8192;

	/**
	 * The '<em><b>HOST WRITE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HOST WRITE BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOST_WRITE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOST_WRITE_BIT_VALUE = 16384;

	/**
	 * The '<em><b>MEMORY READ BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEMORY READ BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMORY_READ_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEMORY_READ_BIT_VALUE = 32768;

	/**
	 * The '<em><b>MEMORY WRITE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEMORY WRITE BIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMORY_WRITE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEMORY_WRITE_BIT_VALUE = 65536;

	/**
	 * An array of all the '<em><b>EAccess</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EAccess[] VALUES_ARRAY =
		new EAccess[]
		{
			INDIRECT_COMMAND_READ_BIT,
			INDEX_READ_BIT,
			VERTEX_ATTRIBUTE_READ_BIT,
			UNIFORM_READ_BIT,
			INPUT_ATTACHMENT_READ_BIT,
			SHADER_READ_BIT,
			SHADER_WRITE_BIT,
			COLOR_ATTACHMENT_READ_BIT,
			COLOR_ATTACHMENT_WRITE_BIT,
			DEPTH_STENCIL_ATTACHMENT_READ_BIT,
			DEPTH_STENCIL_ATTACHMENT_WRITE_BIT,
			TRANSFER_READ_BIT,
			TRANSFER_WRITE_BIT,
			HOST_READ_BIT,
			HOST_WRITE_BIT,
			MEMORY_READ_BIT,
			MEMORY_WRITE_BIT,
		};

	/**
	 * A public read-only list of all the '<em><b>EAccess</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EAccess> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EAccess</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAccess get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EAccess result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EAccess</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAccess getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EAccess result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EAccess</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAccess get(int value)
	{
		switch (value)
		{
			case INDIRECT_COMMAND_READ_BIT_VALUE: return INDIRECT_COMMAND_READ_BIT;
			case INDEX_READ_BIT_VALUE: return INDEX_READ_BIT;
			case VERTEX_ATTRIBUTE_READ_BIT_VALUE: return VERTEX_ATTRIBUTE_READ_BIT;
			case UNIFORM_READ_BIT_VALUE: return UNIFORM_READ_BIT;
			case INPUT_ATTACHMENT_READ_BIT_VALUE: return INPUT_ATTACHMENT_READ_BIT;
			case SHADER_READ_BIT_VALUE: return SHADER_READ_BIT;
			case SHADER_WRITE_BIT_VALUE: return SHADER_WRITE_BIT;
			case COLOR_ATTACHMENT_READ_BIT_VALUE: return COLOR_ATTACHMENT_READ_BIT;
			case COLOR_ATTACHMENT_WRITE_BIT_VALUE: return COLOR_ATTACHMENT_WRITE_BIT;
			case DEPTH_STENCIL_ATTACHMENT_READ_BIT_VALUE: return DEPTH_STENCIL_ATTACHMENT_READ_BIT;
			case DEPTH_STENCIL_ATTACHMENT_WRITE_BIT_VALUE: return DEPTH_STENCIL_ATTACHMENT_WRITE_BIT;
			case TRANSFER_READ_BIT_VALUE: return TRANSFER_READ_BIT;
			case TRANSFER_WRITE_BIT_VALUE: return TRANSFER_WRITE_BIT;
			case HOST_READ_BIT_VALUE: return HOST_READ_BIT;
			case HOST_WRITE_BIT_VALUE: return HOST_WRITE_BIT;
			case MEMORY_READ_BIT_VALUE: return MEMORY_READ_BIT;
			case MEMORY_WRITE_BIT_VALUE: return MEMORY_WRITE_BIT;
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
	private EAccess(int value, String name, String literal)
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
	
} //EAccess
