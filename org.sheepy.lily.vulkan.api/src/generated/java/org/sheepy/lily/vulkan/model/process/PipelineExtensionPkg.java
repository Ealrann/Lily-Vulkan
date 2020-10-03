/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Extension Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg#getExtensions <em>Extensions</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineExtensionPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface PipelineExtensionPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.IPipelineExtension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPipelineExtensionPkg_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<IPipelineExtension> getExtensions();

} // PipelineExtensionPkg
