/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Camera Screen World Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition#getCamera <em>Camera</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCameraScreenWorldPosition()
 * @model
 * @generated
 */
public interface CameraScreenWorldPosition extends IModelVariable
{
	/**
	 * Returns the value of the '<em><b>Camera</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Camera</em>' reference.
	 * @see #setCamera(Camera)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCameraScreenWorldPosition_Camera()
	 * @model required="true"
	 * @generated
	 */
	Camera getCamera();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition#getCamera <em>Camera</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Camera</em>' reference.
	 * @see #getCamera()
	 * @generated
	 */
	void setCamera(Camera value);

} // CameraScreenWorldPosition
