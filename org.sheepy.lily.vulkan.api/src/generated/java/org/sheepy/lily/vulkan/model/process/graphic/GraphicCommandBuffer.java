/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.process.ICommandBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer#getImageID <em>Image ID</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicCommandBuffer()
 * @model
 * @generated
 */
public interface GraphicCommandBuffer extends ICommandBuffer
{

	/**
	 * Returns the value of the '<em><b>Image ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image ID</em>' attribute.
	 * @see #setImageID(int)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getGraphicCommandBuffer_ImageID()
	 * @model required="true"
	 * @generated
	 */
	int getImageID();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer#getImageID <em>Image ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image ID</em>' attribute.
	 * @see #getImageID()
	 * @generated
	 */
	void setImageID(int value);

} // GraphicCommandBuffer
