/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Render Pass Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getAttachments <em>Attachments</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getBindPoint <em>Bind Point</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getRenderPassInfo()
 * @model
 * @generated
 */
public interface RenderPassInfo extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attachments</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachments</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getRenderPassInfo_Attachments()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttachmentDescription> getAttachments();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.process.graphic.SubpassDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getRenderPassInfo_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubpassDependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Bind Point</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bind Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Point</em>' attribute.
	 * @see #setBindPoint(int)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getRenderPassInfo_BindPoint()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getBindPoint();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getBindPoint <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Point</em>' attribute.
	 * @see #getBindPoint()
	 * @generated
	 */
	void setBindPoint(int value);

} // RenderPassInfo
