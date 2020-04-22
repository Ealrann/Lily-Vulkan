/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities <em>Presented Entities</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentation()
 * @model interface="true" abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface Presentation extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Presented Entities</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity}.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presented Entities</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentation_PresentedEntities()
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation
	 * @model opposite="presentation"
	 * @generated
	 */
	EList<PresentableEntity> getPresentedEntities();

} // Presentation
