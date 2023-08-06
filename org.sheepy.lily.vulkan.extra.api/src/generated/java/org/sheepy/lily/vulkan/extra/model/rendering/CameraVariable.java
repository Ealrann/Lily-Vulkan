/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Camera Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable#getCamera <em>Camera</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCameraVariable()
 * @model
 * @generated
 */
public interface CameraVariable extends IModelVariable
{
	/**
	 * Returns the value of the '<em><b>Camera</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Camera</em>' reference.
	 * @see #setCamera(Camera)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCameraVariable_Camera()
	 * @model required="true"
	 * @generated
	 */
	Camera getCamera();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable#getCamera <em>Camera</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Camera</em>' reference.
	 * @see #getCamera()
	 * @generated
	 */
	void setCamera(Camera value);

	/**
	 * Returns the value of the '<em><b>Field</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.extra.model.rendering.ECameraField}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ECameraField
	 * @see #setField(ECameraField)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getCameraVariable_Field()
	 * @model required="true"
	 * @generated
	 */
	ECameraField getField();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable#getField <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ECameraField
	 * @see #getField()
	 * @generated
	 */
	void setField(ECameraField value);

} // CameraVariable
