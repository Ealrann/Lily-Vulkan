/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Resolver Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline#getEntityResolvers <em>Entity Resolvers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline#isTakeFirst <em>Take First</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getEntityResolverPipeline()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface EntityResolverPipeline extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Entity Resolvers</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Resolvers</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getEntityResolverPipeline_EntityResolvers()
	 * @model
	 * @generated
	 */
	EList<IEntityResolver> getEntityResolvers();

	/**
	 * Returns the value of the '<em><b>Take First</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Take First</em>' attribute.
	 * @see #setTakeFirst(boolean)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getEntityResolverPipeline_TakeFirst()
	 * @model default="false"
	 * @generated
	 */
	boolean isTakeFirst();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline#isTakeFirst <em>Take First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Take First</em>' attribute.
	 * @see #isTakeFirst()
	 * @generated
	 */
	void setTakeFirst(boolean value);

} // EntityResolverPipeline
