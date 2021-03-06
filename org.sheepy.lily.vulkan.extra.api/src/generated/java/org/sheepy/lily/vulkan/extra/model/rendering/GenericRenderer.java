/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.maintainer.Maintainer;

import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;

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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getRenderedStructures <em>Rendered Structures</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getTransferBuffer <em>Transfer Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDescriptorProviderPkg <em>Descriptor Provider Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getSpecialization <em>Specialization</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getFlushTransferBufferTask <em>Flush Transfer Buffer Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#isOnePipelinePerPart <em>One Pipeline Per Part</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#isMaintaining <em>Maintaining</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer()
 * @model abstract="true"
 * @generated
 */
public interface GenericRenderer<T extends Structure> extends GraphicsPipeline, Maintainer<GraphicsPipeline>
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
	 * Returns the value of the '<em><b>Rendered Structures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rendered Structures</em>' reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_RenderedStructures()
	 * @model required="true"
	 * @generated
	 */
	EList<T> getRenderedStructures();

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
	 * Returns the value of the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transfer Buffer</em>' reference.
	 * @see #setTransferBuffer(TransferBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_TransferBuffer()
	 * @model required="true"
	 * @generated
	 */
	TransferBuffer getTransferBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getTransferBuffer <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfer Buffer</em>' reference.
	 * @see #getTransferBuffer()
	 * @generated
	 */
	void setTransferBuffer(TransferBuffer value);

	/**
	 * Returns the value of the '<em><b>Descriptor Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Provider Pkg</em>' containment reference.
	 * @see #setDescriptorProviderPkg(ResourceDescriptorProviderPkg)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_DescriptorProviderPkg()
	 * @model containment="true"
	 * @generated
	 */
	ResourceDescriptorProviderPkg getDescriptorProviderPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDescriptorProviderPkg <em>Descriptor Provider Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Provider Pkg</em>' containment reference.
	 * @see #getDescriptorProviderPkg()
	 * @generated
	 */
	void setDescriptorProviderPkg(ResourceDescriptorProviderPkg value);

	/**
	 * Returns the value of the '<em><b>Specialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization</em>' containment reference.
	 * @see #setSpecialization(ISpecialization)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_Specialization()
	 * @model containment="true"
	 * @generated
	 */
	ISpecialization getSpecialization();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getSpecialization <em>Specialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialization</em>' containment reference.
	 * @see #getSpecialization()
	 * @generated
	 */
	void setSpecialization(ISpecialization value);

	/**
	 * Returns the value of the '<em><b>Flush Transfer Buffer Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flush Transfer Buffer Task</em>' reference.
	 * @see #setFlushTransferBufferTask(FlushTransferBufferTask)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_FlushTransferBufferTask()
	 * @model required="true"
	 * @generated
	 */
	FlushTransferBufferTask getFlushTransferBufferTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getFlushTransferBufferTask <em>Flush Transfer Buffer Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flush Transfer Buffer Task</em>' reference.
	 * @see #getFlushTransferBufferTask()
	 * @generated
	 */
	void setFlushTransferBufferTask(FlushTransferBufferTask value);

	/**
	 * Returns the value of the '<em><b>One Pipeline Per Part</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Pipeline Per Part</em>' attribute.
	 * @see #setOnePipelinePerPart(boolean)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_OnePipelinePerPart()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isOnePipelinePerPart();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#isOnePipelinePerPart <em>One Pipeline Per Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Pipeline Per Part</em>' attribute.
	 * @see #isOnePipelinePerPart()
	 * @generated
	 */
	void setOnePipelinePerPart(boolean value);

	/**
	 * Returns the value of the '<em><b>Maintaining</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maintaining</em>' attribute.
	 * @see #setMaintaining(boolean)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getGenericRenderer_Maintaining()
	 * @model default="true"
	 * @generated
	 */
	boolean isMaintaining();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#isMaintaining <em>Maintaining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maintaining</em>' attribute.
	 * @see #isMaintaining()
	 * @generated
	 */
	void setMaintaining(boolean value);

} // GenericRenderer
