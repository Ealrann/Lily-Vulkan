/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mouse Pick Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getMousePickBuffer <em>Mouse Pick Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getSelectionProxy <em>Selection Proxy</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getEntityResolverPipelines <em>Entity Resolver Pipelines</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getResolverPipelineOffset <em>Resolver Pipeline Offset</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension()
 * @model
 * @generated
 */
public interface MousePickExtension extends IProcessExtension
{
	/**
	 * Returns the value of the '<em><b>Mouse Pick Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mouse Pick Buffer</em>' reference.
	 * @see #setMousePickBuffer(StaticBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension_MousePickBuffer()
	 * @model required="true"
	 * @generated
	 */
	StaticBuffer getMousePickBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getMousePickBuffer <em>Mouse Pick Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mouse Pick Buffer</em>' reference.
	 * @see #getMousePickBuffer()
	 * @generated
	 */
	void setMousePickBuffer(StaticBuffer value);

	/**
	 * Returns the value of the '<em><b>Selection Proxy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Proxy</em>' reference.
	 * @see #setSelectionProxy(SelectionProxy)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension_SelectionProxy()
	 * @model
	 * @generated
	 */
	SelectionProxy getSelectionProxy();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getSelectionProxy <em>Selection Proxy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Proxy</em>' reference.
	 * @see #getSelectionProxy()
	 * @generated
	 */
	void setSelectionProxy(SelectionProxy value);

	/**
	 * Returns the value of the '<em><b>Entity Resolver Pipelines</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity Resolver Pipelines</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension_EntityResolverPipelines()
	 * @model containment="true"
	 * @generated
	 */
	EList<EntityResolverPipeline> getEntityResolverPipelines();

	/**
	 * Returns the value of the '<em><b>Resolver Pipeline Offset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolver Pipeline Offset</em>' attribute.
	 * @see #setResolverPipelineOffset(int)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension_ResolverPipelineOffset()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getResolverPipelineOffset();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getResolverPipelineOffset <em>Resolver Pipeline Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolver Pipeline Offset</em>' attribute.
	 * @see #getResolverPipelineOffset()
	 * @generated
	 */
	void setResolverPipelineOffset(int value);

} // MousePickExtension
