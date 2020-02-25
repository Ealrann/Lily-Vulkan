/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;

import org.sheepy.vulkan.model.pipeline.PushConstantRange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vk Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getSpecializationData <em>Specialization Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getPushConstantRanges <em>Push Constant Ranges</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getVkPipeline()
 * @model abstract="true"
 * @generated
 */
public interface VkPipeline extends TaskPipeline
{
	/**
	 * Returns the value of the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set Pkg</em>' containment reference.
	 * @see #setDescriptorSetPkg(DescriptorSetPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getVkPipeline_DescriptorSetPkg()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorSetPkg getDescriptorSetPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set Pkg</em>' containment reference.
	 * @see #getDescriptorSetPkg()
	 * @generated
	 */
	void setDescriptorSetPkg(DescriptorSetPkg value);

	/**
	 * Returns the value of the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization Data</em>' reference.
	 * @see #setSpecializationData(ConstantBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getVkPipeline_SpecializationData()
	 * @model
	 * @generated
	 */
	ConstantBuffer getSpecializationData();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getSpecializationData <em>Specialization Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialization Data</em>' reference.
	 * @see #getSpecializationData()
	 * @generated
	 */
	void setSpecializationData(ConstantBuffer value);

	/**
	 * Returns the value of the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.pipeline.PushConstantRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Constant Ranges</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getVkPipeline_PushConstantRanges()
	 * @model containment="true"
	 * @generated
	 */
	EList<PushConstantRange> getPushConstantRanges();

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getVkPipeline_Layout()
	 * @model
	 * @generated
	 */
	EList<DescriptorSet> getLayout();

} // VkPipeline
