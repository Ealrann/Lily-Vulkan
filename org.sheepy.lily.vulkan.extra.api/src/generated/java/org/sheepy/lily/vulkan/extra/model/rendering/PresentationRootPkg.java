/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentation Root Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationRootPkg#getPresentationPkgs <em>Presentation Pkgs</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentationRootPkg()
 * @model
 * @generated
 */
public interface PresentationRootPkg extends EObject
{
	/**
	 * Returns the value of the '<em><b>Presentation Pkgs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg}<code>&lt;? extends org.sheepy.lily.vulkan.extra.model.rendering.Presentation&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Pkgs</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentationRootPkg_PresentationPkgs()
	 * @model containment="true"
	 * @generated
	 */
	EList<PresentationPkg<? extends Presentation>> getPresentationPkgs();

} // PresentationRootPkg
