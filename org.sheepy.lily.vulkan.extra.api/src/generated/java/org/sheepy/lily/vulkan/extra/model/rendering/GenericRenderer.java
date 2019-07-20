/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.core.model.maintainer.Maintainer;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDataProviderPkg <em>Data Provider Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getPresentationPkg <em>Presentation Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getPushBuffer <em>Push Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getCommonResourceProvider <em>Common Resource Provider</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer()
 * @model abstract="true"
 * @generated
 */
public interface GenericRenderer<T extends Presentation> extends GraphicsPipeline, Maintainer<GraphicsPipeline>
{
	/**
	 * Returns the value of the '<em><b>Data Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider Pkg</em>' containment reference.
	 * @see #setDataProviderPkg(DataProviderPkg)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_DataProviderPkg()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataProviderPkg<T> getDataProviderPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDataProviderPkg <em>Data Provider Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider Pkg</em>' containment reference.
	 * @see #getDataProviderPkg()
	 * @generated
	 */
	void setDataProviderPkg(DataProviderPkg<T> value);

	/**
	 * Returns the value of the '<em><b>Presentation Pkg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Pkg</em>' reference.
	 * @see #setPresentationPkg(PresentationPkg)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_PresentationPkg()
	 * @model required="true"
	 * @generated
	 */
	PresentationPkg<? extends T> getPresentationPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getPresentationPkg <em>Presentation Pkg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Pkg</em>' reference.
	 * @see #getPresentationPkg()
	 * @generated
	 */
	void setPresentationPkg(PresentationPkg<? extends T> value);

	/**
	 * Returns the value of the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Buffer</em>' reference.
	 * @see #setConstantBuffer(ConstantBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_ConstantBuffer()
	 * @model
	 * @generated
	 */
	ConstantBuffer getConstantBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getConstantBuffer <em>Constant Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Buffer</em>' reference.
	 * @see #getConstantBuffer()
	 * @generated
	 */
	void setConstantBuffer(ConstantBuffer value);

	/**
	 * Returns the value of the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Buffer</em>' reference.
	 * @see #setPushBuffer(PushBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_PushBuffer()
	 * @model required="true"
	 * @generated
	 */
	PushBuffer getPushBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getPushBuffer <em>Push Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Push Buffer</em>' reference.
	 * @see #getPushBuffer()
	 * @generated
	 */
	void setPushBuffer(PushBuffer value);

	/**
	 * Returns the value of the '<em><b>Common Resource Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Common Resource Provider</em>' containment reference.
	 * @see #setCommonResourceProvider(ResourceProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_CommonResourceProvider()
	 * @model containment="true"
	 * @generated
	 */
	ResourceProvider getCommonResourceProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getCommonResourceProvider <em>Common Resource Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Common Resource Provider</em>' containment reference.
	 * @see #getCommonResourceProvider()
	 * @generated
	 */
	void setCommonResourceProvider(ResourceProvider value);

} // GenericRenderer
