/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Render Pass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPass#getAttachments <em>Attachments</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getRenderPass()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface RenderPass extends ILilyEObject
{

	/**
	 * Returns the value of the '<em><b>Attachments</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachments</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getRenderPass_Attachments()
	 * @model
	 * @generated
	 */
	EList<ExtraAttachment> getAttachments();
} // RenderPass
