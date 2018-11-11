/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.sheepy.vulkan.model.process.PipelineBarrier;

import org.sheepy.vulkan.model.resource.ImageBarrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier#getImageBarrier <em>Image Barrier</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getPipelineImageBarrier()
 * @model
 * @generated
 */
public interface PipelineImageBarrier extends PipelineBarrier
{
	/**
	 * Returns the value of the '<em><b>Image Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Barrier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Barrier</em>' containment reference.
	 * @see #setImageBarrier(ImageBarrier)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getPipelineImageBarrier_ImageBarrier()
	 * @model containment="true"
	 * @generated
	 */
	ImageBarrier getImageBarrier();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier#getImageBarrier <em>Image Barrier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Barrier</em>' containment reference.
	 * @see #getImageBarrier()
	 * @generated
	 */
	void setImageBarrier(ImageBarrier value);

} // PipelineImageBarrier
