/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Provider Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg#getDataProviders <em>Data Providers</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProviderPkg()
 * @model
 * @generated
 */
public interface DataProviderPkg<T extends Presentation> extends EObject
{
	/**
	 * Returns the value of the '<em><b>Data Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.GenericDataProvider}<code>&lt;T&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Providers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProviderPkg_DataProviders()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<GenericDataProvider<T>> getDataProviders();

} // DataProviderPkg
