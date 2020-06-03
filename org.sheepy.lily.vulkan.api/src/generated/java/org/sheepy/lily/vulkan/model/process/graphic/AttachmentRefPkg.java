/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachment Ref Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg#getAttachmentRefs <em>Attachment Refs</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRefPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface AttachmentRefPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Attachment Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment Refs</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRefPkg_AttachmentRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttachmentRef> getAttachmentRefs();

} // AttachmentRefPkg
