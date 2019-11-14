/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getEntityPkg()
 * @model abstract="true"
 * @extends ILilyEObject
 * @generated
 */
public interface EntityPkg<T extends Entity> extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getEntityPkg_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<T> getEntities();

} // EntityPkg
