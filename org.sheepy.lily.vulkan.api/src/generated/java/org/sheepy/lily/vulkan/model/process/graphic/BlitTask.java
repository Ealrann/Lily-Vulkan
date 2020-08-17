/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blit Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BlitTask#getDstImage <em>Dst Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBlitTask()
 * @model
 * @generated
 */
public interface BlitTask extends AbstractBlitTask
{
	/**
	 * Returns the value of the '<em><b>Dst Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Image</em>' reference.
	 * @see #setDstImage(IVulkanImage)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBlitTask_DstImage()
	 * @model required="true"
	 * @generated
	 */
	IVulkanImage getDstImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BlitTask#getDstImage <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Image</em>' reference.
	 * @see #getDstImage()
	 * @generated
	 */
	void setDstImage(IVulkanImage value);

} // BlitTask
