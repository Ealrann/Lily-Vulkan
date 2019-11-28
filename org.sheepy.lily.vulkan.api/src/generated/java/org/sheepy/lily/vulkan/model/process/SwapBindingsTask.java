/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Swap Bindings Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getTask <em>Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getDescriptorSets <em>Descriptor Sets</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSwapBindingsTask()
 * @model
 * @generated
 */
public interface SwapBindingsTask extends ICadenceTask
{
	/**
	 * Returns the value of the '<em><b>Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' reference.
	 * @see #setTask(BindDescriptorSets)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSwapBindingsTask_Task()
	 * @model required="true"
	 * @generated
	 */
	BindDescriptorSets getTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getTask <em>Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(BindDescriptorSets value);

	/**
	 * Returns the value of the '<em><b>Descriptor Sets</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Sets</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSwapBindingsTask_DescriptorSets()
	 * @model required="true"
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorSets();

} // SwapBindingsTask
