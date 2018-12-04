/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.IProcessPool;

import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Process Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractProcessPool#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractProcessPool#getProcesses <em>Processes</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractProcessPool#getResources <em>Resources</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.AbstractProcessPool#isResetAllowed <em>Reset Allowed</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractProcessPool()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProcessPool<T extends AbstractProcess> extends IProcessPool
{
	/**
	 * Returns the value of the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Sets</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractProcessPool_DescriptorSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorSets();

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractProcessPool_Processes()
	 * @model containment="true"
	 * @generated
	 */
	EList<T> getProcesses();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.resource.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractProcessPool_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset Allowed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Allowed</em>' attribute.
	 * @see #setResetAllowed(boolean)
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#getAbstractProcessPool_ResetAllowed()
	 * @model unique="false"
	 * @generated
	 */
	boolean isResetAllowed();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.AbstractProcessPool#isResetAllowed <em>Reset Allowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Allowed</em>' attribute.
	 * @see #isResetAllowed()
	 * @generated
	 */
	void setResetAllowed(boolean value);

} // AbstractProcessPool
