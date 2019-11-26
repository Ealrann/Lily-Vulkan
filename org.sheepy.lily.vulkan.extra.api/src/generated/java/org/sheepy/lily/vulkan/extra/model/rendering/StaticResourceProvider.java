/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.vulkan.model.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Resource Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getStaticResourceProvider()
 * @model
 * @generated
 */
public interface StaticResourceProvider extends ResourceProvider
{
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.IResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getStaticResourceProvider_Resources()
	 * @model required="true"
	 * @generated
	 */
	EList<IResource> getResources();

} // StaticResourceProvider
