/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.maintainer.Maintainable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CompositeTask#getRepeatCount <em>Repeat Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CompositeTask#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCompositeTask()
 * @model
 * @generated
 */
public interface CompositeTask extends IPipelineTask, Maintainable<CompositeTask>
{
	/**
	 * Returns the value of the '<em><b>Repeat Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat Count</em>' attribute.
	 * @see #setRepeatCount(int)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCompositeTask_RepeatCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getRepeatCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CompositeTask#getRepeatCount <em>Repeat Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat Count</em>' attribute.
	 * @see #getRepeatCount()
	 * @generated
	 */
	void setRepeatCount(int value);

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.IPipelineTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCompositeTask_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<IPipelineTask> getTasks();

} // CompositeTask
