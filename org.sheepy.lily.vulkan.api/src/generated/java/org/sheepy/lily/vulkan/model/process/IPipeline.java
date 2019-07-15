/**
 */
package org.sheepy.lily.vulkan.model.process;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.model.IResourceContainer;

import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;

import org.sheepy.vulkan.model.enumeration.ECommandStage;

import org.sheepy.vulkan.model.pipeline.PushConstantRange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipeline#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipeline#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipeline#getPushConstantRanges <em>Push Constant Ranges</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipeline#getSpecializationData <em>Specialization Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipeline#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipeline#getTaskPkg <em>Task Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPipeline extends LNamedElement, IResourceContainer, IProcessPart
{
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.IPipeline#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The default value is <code>"Render"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECommandStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #setStage(ECommandStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline_Stage()
	 * @model default="Render" unique="false"
	 * @generated
	 */
	ECommandStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ECommandStage value);

	/**
	 * Returns the value of the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.pipeline.PushConstantRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Constant Ranges</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline_PushConstantRanges()
	 * @model containment="true"
	 * @generated
	 */
	EList<PushConstantRange> getPushConstantRanges();

	/**
	 * Returns the value of the '<em><b>Specialization Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization Data</em>' attribute.
	 * @see #setSpecializationData(ByteBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline_SpecializationData()
	 * @model unique="false" dataType="org.sheepy.lily.vulkan.model.resource.ByteBuffer"
	 * @generated
	 */
	ByteBuffer getSpecializationData();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getSpecializationData <em>Specialization Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialization Data</em>' attribute.
	 * @see #getSpecializationData()
	 * @generated
	 */
	void setSpecializationData(ByteBuffer value);

	/**
	 * Returns the value of the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set Pkg</em>' containment reference.
	 * @see #setDescriptorSetPkg(DescriptorSetPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline_DescriptorSetPkg()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorSetPkg getDescriptorSetPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set Pkg</em>' containment reference.
	 * @see #getDescriptorSetPkg()
	 * @generated
	 */
	void setDescriptorSetPkg(DescriptorSetPkg value);

	/**
	 * Returns the value of the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Pkg</em>' containment reference.
	 * @see #setTaskPkg(TaskPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipeline_TaskPkg()
	 * @model containment="true"
	 * @generated
	 */
	TaskPkg getTaskPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getTaskPkg <em>Task Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Pkg</em>' containment reference.
	 * @see #getTaskPkg()
	 * @generated
	 */
	void setTaskPkg(TaskPkg value);

} // IPipeline
