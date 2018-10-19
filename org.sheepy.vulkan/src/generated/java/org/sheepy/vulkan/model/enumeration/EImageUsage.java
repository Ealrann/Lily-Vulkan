/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EImage Usage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEImageUsage()
 * @model
 * @generated
 */
public enum EImageUsage implements Enumerator
{
	/**
	 * The '<em><b>Transfer Src</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_SRC_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_SRC(1, "TransferSrc", "TransferSrc"),
	/**
	 * The '<em><b>Transfer Dst</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_DST_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSFER_DST(2, "TransferDst", "TransferDst"),
	/**
	 * The '<em><b>Sampled</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAMPLED_VALUE
	 * @generated
	 * @ordered
	 */
	SAMPLED(4, "Sampled", "Sampled"),
	/**
	 * The '<em><b>Storage</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGE_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGE(8, "Storage", "Storage"),
	/**
	 * The '<em><b>Color Attachment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR_ATTACHMENT(16, "ColorAttachment", "ColorAttachment"),
	/**
	 * The '<em><b>Depth Stencil Attachment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_STENCIL_ATTACHMENT(32, "DepthStencilAttachment", "DepthStencilAttachment"),
	/**
	 * The '<em><b>Transient Attachment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSIENT_ATTACHMENT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSIENT_ATTACHMENT(64, "TransientAttachment", "TransientAttachment"),
	/**
	 * The '<em><b>Input Attachement</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_ATTACHEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_ATTACHEMENT(128, "InputAttachement", "InputAttachement");
	/**
	 * The '<em><b>Transfer Src</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Transfer Src</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_SRC
	 * @model name="TransferSrc"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_SRC_VALUE = 1;

	/**
	 * The '<em><b>Transfer Dst</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Transfer Dst</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSFER_DST
	 * @model name="TransferDst"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFER_DST_VALUE = 2;

	/**
	 * The '<em><b>Sampled</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sampled</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAMPLED
	 * @model name="Sampled"
	 * @generated
	 * @ordered
	 */
	public static final int SAMPLED_VALUE = 4;

	/**
	 * The '<em><b>Storage</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Storage</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORAGE
	 * @model name="Storage"
	 * @generated
	 * @ordered
	 */
	public static final int STORAGE_VALUE = 8;

	/**
	 * The '<em><b>Color Attachment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Color Attachment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLOR_ATTACHMENT
	 * @model name="ColorAttachment"
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_ATTACHMENT_VALUE = 16;

	/**
	 * The '<em><b>Depth Stencil Attachment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Depth Stencil Attachment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEPTH_STENCIL_ATTACHMENT
	 * @model name="DepthStencilAttachment"
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_STENCIL_ATTACHMENT_VALUE = 32;

	/**
	 * The '<em><b>Transient Attachment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Transient Attachment</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSIENT_ATTACHMENT
	 * @model name="TransientAttachment"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSIENT_ATTACHMENT_VALUE = 64;

	/**
	 * The '<em><b>Input Attachement</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Input Attachement</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_ATTACHEMENT
	 * @model name="InputAttachement"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_ATTACHEMENT_VALUE = 128;

	/**
	 * An array of all the '<em><b>EImage Usage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EImageUsage[] VALUES_ARRAY =
		new EImageUsage[]
		{
			TRANSFER_SRC,
			TRANSFER_DST,
			SAMPLED,
			STORAGE,
			COLOR_ATTACHMENT,
			DEPTH_STENCIL_ATTACHMENT,
			TRANSIENT_ATTACHMENT,
			INPUT_ATTACHEMENT,
		};

	/**
	 * A public read-only list of all the '<em><b>EImage Usage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EImageUsage> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EImage Usage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EImageUsage get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EImageUsage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EImage Usage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EImageUsage getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EImageUsage result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EImage Usage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EImageUsage get(int value)
	{
		switch (value)
		{
			case TRANSFER_SRC_VALUE: return TRANSFER_SRC;
			case TRANSFER_DST_VALUE: return TRANSFER_DST;
			case SAMPLED_VALUE: return SAMPLED;
			case STORAGE_VALUE: return STORAGE;
			case COLOR_ATTACHMENT_VALUE: return COLOR_ATTACHMENT;
			case DEPTH_STENCIL_ATTACHMENT_VALUE: return DEPTH_STENCIL_ATTACHMENT;
			case TRANSIENT_ATTACHMENT_VALUE: return TRANSIENT_ATTACHMENT;
			case INPUT_ATTACHEMENT_VALUE: return INPUT_ATTACHEMENT;
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
	private EImageUsage(int value, String name, String literal)
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
}
