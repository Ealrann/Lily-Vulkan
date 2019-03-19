/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.joml.Vector4f;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Framebuffer Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration#getClearValue <em>Clear Value</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration#getAtachments <em>Atachments</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getFramebufferConfiguration()
 * @model
 * @generated
 */
public interface FramebufferConfiguration extends EObject
{

	/**
	 * Returns the value of the '<em><b>Clear Value</b></em>' attribute.
	 * The default value is <code>"0;0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Value</em>' attribute.
	 * @see #setClearValue(Vector4f)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getFramebufferConfiguration_ClearValue()
	 * @model default="0;0;0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Color4f"
	 * @generated
	 */
	Vector4f getClearValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration#getClearValue <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Value</em>' attribute.
	 * @see #getClearValue()
	 * @generated
	 */
	void setClearValue(Vector4f value);

	/**
	 * Returns the value of the '<em><b>Atachments</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.IFramebufferAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atachments</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getFramebufferConfiguration_Atachments()
	 * @model containment="true"
	 * @generated
	 */
	EList<IFramebufferAttachment> getAtachments();

} // FramebufferConfiguration
