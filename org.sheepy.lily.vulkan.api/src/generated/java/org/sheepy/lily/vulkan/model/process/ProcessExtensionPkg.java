/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg#getExtensions <em>Extensions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getProcessExtensionPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ProcessExtensionPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.IProcessExtension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getProcessExtensionPkg_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<IProcessExtension> getExtensions();

} // ProcessExtensionPkg
