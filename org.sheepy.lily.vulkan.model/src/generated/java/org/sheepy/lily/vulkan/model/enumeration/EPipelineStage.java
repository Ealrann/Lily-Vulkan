/**
 */
package org.sheepy.lily.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EPipeline Stage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.enumeration.EnumerationPackage#getEPipelineStage()
 * @model
 * @generated
 */
public enum EPipelineStage implements Enumerator
{
	/**
	 * The '<em><b>TOP OF PIPE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_OF_PIPE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_OF_PIPE_BIT(1, "TOP_OF_PIPE_BIT", "TOP_OF_PIPE_BIT"),

	/**
	 * The '<em><b>DRAW INDIRECT BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAW_INDIRECT_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	DRAW_INDIRECT_BIT(2, "DRAW_INDIRECT_BIT", "DRAW_INDIRECT_BIT"),

	/**
	 * The '<em><b>VERTEX INPUT BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_INPUT_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	VERTEX_INPUT_BIT(4, "VERTEX_INPUT_BIT", "VERTEX_INPUT_BIT"),

	/**
	 * The '<em><b>VERTEX SHADER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_SHADER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	VERTEX_SHADER_BIT(8, "VERTEX_SHADER_BIT", "VERTEX_SHADER_BIT"),

	/**
	 * The '<em><b>TESSELLATION CONTROL SHADER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_CONTROL_SHADER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TESSELLATION_CONTROL_SHADER_BIT(
			16,
			"TESSELLATION_CONTROL_SHADER_BIT",
			"TESSELLATION_CONTROL_SHADER_BIT"),

	/**
	 * The '<em><b>TESSELLATION EVALUATION SHADER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_EVALUATION_SHADER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TESSELLATION_EVALUATION_SHADER_BIT(
			32,
			"TESSELLATION_EVALUATION_SHADER_BIT",
			"TESSELLATION_EVALUATION_SHADER_BIT"),

	/**
	 * The '<em><b>GEOMETRY SHADER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEOMETRY_SHADER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	GEOMETRY_SHADER_BIT(64, "GEOMETRY_SHADER_BIT", "GEOMETRY_SHADER_BIT"),

	/**
	 * The '<em><b>FRAGMENT SHADER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRAGMENT_SHADER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	FRAGMENT_SHADER_BIT(128, "FRAGMENT_SHADER_BIT", "FRAGMENT_SHADER_BIT"),

	/**
	 * The '<em><b>EARLY FRAGMENT TESTS BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARLY_FRAGMENT_TESTS_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	EARLY_FRAGMENT_TESTS_BIT(256, "EARLY_FRAGMENT_TESTS_BIT", "EARLY_FRAGMENT_TESTS_BIT"),

	/**
	 * The '<em><b>LATE FRAGMENT TESTS BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATE_FRAGMENT_TESTS_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	LATE_FRAGMENT_TESTS_BIT(512, "LATE_FRAGMENT_TESTS_BIT", "LATE_FRAGMENT_TESTS_BIT"),

	/**
	 * The '<em><b>COLOR ATTACHMENT OUTPUT BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_OUTPUT_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR_ATTACHMENT_OUTPUT_BIT(1024, "COLOR_ATTACHMENT_OUTPUT_BIT", "COLOR_ATTACHMENT_OUTPUT_BIT"),

	/**
	 * The '<em><b>COMPUTE SHADER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTE_SHADER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTE_SHADER_BIT(2048, "COMPUTE_SHADER_BIT", "COMPUTE_SHADER_BIT"),

	/**
	 * The '<em><b>TRANSFER BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_BIT(4096, "TRANSFER_BIT", "TRANSFER_BIT"),

	/**
	 * The '<em><b>BOTTOM OF PIPE BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_OF_PIPE_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_OF_PIPE_BIT(8192, "BOTTOM_OF_PIPE_BIT", "BOTTOM_OF_PIPE_BIT"),

	/**
	 * The '<em><b>HOST BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	HOST_BIT(16384, "HOST_BIT", "HOST_BIT"),

	/**
	 * The '<em><b>ALL GRAPHICS BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_GRAPHICS_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_GRAPHICS_BIT(32768, "ALL_GRAPHICS_BIT", "ALL_GRAPHICS_BIT"),

	/**
	 * The '<em><b>ALL COMMANDS BIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_COMMANDS_BIT_VALUE
	 * @generated
	 * @ordered
	 */
	ALL_COMMANDS_BIT(65536, "ALL_COMMANDS_BIT", "ALL_COMMANDS_BIT");

	/**
	 * The '<em><b>TOP OF PIPE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_OF_PIPE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOP_OF_PIPE_BIT_VALUE = 1;

	/**
	 * The '<em><b>DRAW INDIRECT BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAW_INDIRECT_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRAW_INDIRECT_BIT_VALUE = 2;

	/**
	 * The '<em><b>VERTEX INPUT BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_INPUT_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERTEX_INPUT_BIT_VALUE = 4;

	/**
	 * The '<em><b>VERTEX SHADER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERTEX_SHADER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERTEX_SHADER_BIT_VALUE = 8;

	/**
	 * The '<em><b>TESSELLATION CONTROL SHADER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_CONTROL_SHADER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TESSELLATION_CONTROL_SHADER_BIT_VALUE = 16;

	/**
	 * The '<em><b>TESSELLATION EVALUATION SHADER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TESSELLATION_EVALUATION_SHADER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TESSELLATION_EVALUATION_SHADER_BIT_VALUE = 32;

	/**
	 * The '<em><b>GEOMETRY SHADER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GEOMETRY_SHADER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GEOMETRY_SHADER_BIT_VALUE = 64;

	/**
	 * The '<em><b>FRAGMENT SHADER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRAGMENT_SHADER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRAGMENT_SHADER_BIT_VALUE = 128;

	/**
	 * The '<em><b>EARLY FRAGMENT TESTS BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARLY_FRAGMENT_TESTS_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EARLY_FRAGMENT_TESTS_BIT_VALUE = 256;

	/**
	 * The '<em><b>LATE FRAGMENT TESTS BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATE_FRAGMENT_TESTS_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LATE_FRAGMENT_TESTS_BIT_VALUE = 512;

	/**
	 * The '<em><b>COLOR ATTACHMENT OUTPUT BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_OUTPUT_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_ATTACHMENT_OUTPUT_BIT_VALUE = 1024;

	/**
	 * The '<em><b>COMPUTE SHADER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTE_SHADER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTE_SHADER_BIT_VALUE = 2048;

	/**
	 * The '<em><b>TRANSFER BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_BIT_VALUE = 4096;

	/**
	 * The '<em><b>BOTTOM OF PIPE BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_OF_PIPE_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_OF_PIPE_BIT_VALUE = 8192;

	/**
	 * The '<em><b>HOST BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOST_BIT_VALUE = 16384;

	/**
	 * The '<em><b>ALL GRAPHICS BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_GRAPHICS_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_GRAPHICS_BIT_VALUE = 32768;

	/**
	 * The '<em><b>ALL COMMANDS BIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_COMMANDS_BIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALL_COMMANDS_BIT_VALUE = 65536;

	/**
	 * An array of all the '<em><b>EPipeline Stage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EPipelineStage[] VALUES_ARRAY = new EPipelineStage[] {
			TOP_OF_PIPE_BIT,
			DRAW_INDIRECT_BIT,
			VERTEX_INPUT_BIT,
			VERTEX_SHADER_BIT,
			TESSELLATION_CONTROL_SHADER_BIT,
			TESSELLATION_EVALUATION_SHADER_BIT,
			GEOMETRY_SHADER_BIT,
			FRAGMENT_SHADER_BIT,
			EARLY_FRAGMENT_TESTS_BIT,
			LATE_FRAGMENT_TESTS_BIT,
			COLOR_ATTACHMENT_OUTPUT_BIT,
			COMPUTE_SHADER_BIT,
			TRANSFER_BIT,
			BOTTOM_OF_PIPE_BIT,
			HOST_BIT,
			ALL_GRAPHICS_BIT,
			ALL_COMMANDS_BIT,
	};

	/**
	 * A public read-only list of all the '<em><b>EPipeline Stage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EPipelineStage> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EPipeline Stage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPipelineStage get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EPipelineStage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EPipeline Stage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPipelineStage getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EPipelineStage result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EPipeline Stage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EPipelineStage get(int value)
	{
		switch (value)
		{
		case TOP_OF_PIPE_BIT_VALUE:
			return TOP_OF_PIPE_BIT;
		case DRAW_INDIRECT_BIT_VALUE:
			return DRAW_INDIRECT_BIT;
		case VERTEX_INPUT_BIT_VALUE:
			return VERTEX_INPUT_BIT;
		case VERTEX_SHADER_BIT_VALUE:
			return VERTEX_SHADER_BIT;
		case TESSELLATION_CONTROL_SHADER_BIT_VALUE:
			return TESSELLATION_CONTROL_SHADER_BIT;
		case TESSELLATION_EVALUATION_SHADER_BIT_VALUE:
			return TESSELLATION_EVALUATION_SHADER_BIT;
		case GEOMETRY_SHADER_BIT_VALUE:
			return GEOMETRY_SHADER_BIT;
		case FRAGMENT_SHADER_BIT_VALUE:
			return FRAGMENT_SHADER_BIT;
		case EARLY_FRAGMENT_TESTS_BIT_VALUE:
			return EARLY_FRAGMENT_TESTS_BIT;
		case LATE_FRAGMENT_TESTS_BIT_VALUE:
			return LATE_FRAGMENT_TESTS_BIT;
		case COLOR_ATTACHMENT_OUTPUT_BIT_VALUE:
			return COLOR_ATTACHMENT_OUTPUT_BIT;
		case COMPUTE_SHADER_BIT_VALUE:
			return COMPUTE_SHADER_BIT;
		case TRANSFER_BIT_VALUE:
			return TRANSFER_BIT;
		case BOTTOM_OF_PIPE_BIT_VALUE:
			return BOTTOM_OF_PIPE_BIT;
		case HOST_BIT_VALUE:
			return HOST_BIT;
		case ALL_GRAPHICS_BIT_VALUE:
			return ALL_GRAPHICS_BIT;
		case ALL_COMMANDS_BIT_VALUE:
			return ALL_COMMANDS_BIT;
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
	private EPipelineStage(int value, String name, String literal)
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

} //EPipelineStage
