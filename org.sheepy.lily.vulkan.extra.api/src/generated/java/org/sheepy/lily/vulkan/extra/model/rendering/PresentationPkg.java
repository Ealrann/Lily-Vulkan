/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentation Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg#getStructures <em>Structures</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentationPkg()
 * @model
 * @generated
 */
public interface PresentationPkg extends EObject
{
	/**
	 * Returns the value of the '<em><b>Structures</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.Structure}<code>&lt;?&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structures</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentationPkg_Structures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Structure<?>> getStructures();

} // PresentationPkg
