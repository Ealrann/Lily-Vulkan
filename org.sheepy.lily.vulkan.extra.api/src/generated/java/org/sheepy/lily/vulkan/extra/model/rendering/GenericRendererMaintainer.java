/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.maintainer.Maintainer;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Renderer Maintainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getDataProviders <em>Data Providers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getPresentationPkg <em>Presentation Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getBasicResources <em>Basic Resources</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getPushBuffer <em>Push Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRendererMaintainer()
 * @model abstract="true"
 * @generated
 */
public interface GenericRendererMaintainer<T extends Presentation> extends GraphicsPipeline, Maintainer<GraphicsPipeline>
{
	/**
	 * Returns the value of the '<em><b>Data Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.rendering.GenericDataProvider}<code>&lt;T&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Providers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRendererMaintainer_DataProviders()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<GenericDataProvider<T>> getDataProviders();

	/**
	 * Returns the value of the '<em><b>Presentation Pkg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Pkg</em>' reference.
	 * @see #setPresentationPkg(PresentationPkg)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRendererMaintainer_PresentationPkg()
	 * @model required="true"
	 * @generated
	 */
	PresentationPkg getPresentationPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getPresentationPkg <em>Presentation Pkg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Pkg</em>' reference.
	 * @see #getPresentationPkg()
	 * @generated
	 */
	void setPresentationPkg(PresentationPkg value);

	/**
	 * Returns the value of the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Buffer</em>' reference.
	 * @see #setConstantBuffer(ConstantBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRendererMaintainer_ConstantBuffer()
	 * @model
	 * @generated
	 */
	ConstantBuffer getConstantBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getConstantBuffer <em>Constant Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Buffer</em>' reference.
	 * @see #getConstantBuffer()
	 * @generated
	 */
	void setConstantBuffer(ConstantBuffer value);

	/**
	 * Returns the value of the '<em><b>Basic Resources</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptedResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Resources</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRendererMaintainer_BasicResources()
	 * @model
	 * @generated
	 */
	EList<DescriptedResource> getBasicResources();

	/**
	 * Returns the value of the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Buffer</em>' reference.
	 * @see #setPushBuffer(PushBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRendererMaintainer_PushBuffer()
	 * @model required="true"
	 * @generated
	 */
	PushBuffer getPushBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer#getPushBuffer <em>Push Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Push Buffer</em>' reference.
	 * @see #getPushBuffer()
	 * @generated
	 */
	void setPushBuffer(PushBuffer value);

} // GenericRendererMaintainer
