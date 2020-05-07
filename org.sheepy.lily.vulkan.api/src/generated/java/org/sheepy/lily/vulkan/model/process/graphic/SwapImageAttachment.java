/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.joml.Vector4fc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Swap Image Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment#getClearValue <em>Clear Value</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapImageAttachment()
 * @model
 * @generated
 */
public interface SwapImageAttachment extends Attachment
{

	/**
	 * Returns the value of the '<em><b>Clear Value</b></em>' attribute.
	 * The default value is <code>"0;0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Value</em>' attribute.
	 * @see #setClearValue(Vector4fc)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getSwapImageAttachment_ClearValue()
	 * @model default="0;0;0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Color4f"
	 * @generated
	 */
	Vector4fc getClearValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment#getClearValue <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Value</em>' attribute.
	 * @see #getClearValue()
	 * @generated
	 */
	void setClearValue(Vector4fc value);
} // SwapImageAttachment
