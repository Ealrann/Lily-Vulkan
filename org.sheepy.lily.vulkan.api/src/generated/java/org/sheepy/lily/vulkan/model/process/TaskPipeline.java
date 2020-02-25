/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.IResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.TaskPipeline#getTaskPkg <em>Task Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getTaskPipeline()
 * @model abstract="true"
 * @generated
 */
public interface TaskPipeline extends AbstractPipeline, IResourceContainer
{
	/**
	 * Returns the value of the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Pkg</em>' containment reference.
	 * @see #setTaskPkg(TaskPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getTaskPipeline_TaskPkg()
	 * @model containment="true"
	 * @generated
	 */
	TaskPkg getTaskPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.TaskPipeline#getTaskPkg <em>Task Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Pkg</em>' containment reference.
	 * @see #getTaskPkg()
	 * @generated
	 */
	void setTaskPkg(TaskPkg value);

} // TaskPipeline
