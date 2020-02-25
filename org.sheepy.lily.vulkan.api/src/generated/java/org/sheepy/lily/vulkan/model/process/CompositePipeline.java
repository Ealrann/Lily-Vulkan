/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CompositePipeline#getPipelines <em>Pipelines</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CompositePipeline#getRepeat <em>Repeat</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCompositePipeline()
 * @model
 * @generated
 */
public interface CompositePipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Pipelines</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.TaskPipeline}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipelines</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCompositePipeline_Pipelines()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskPipeline> getPipelines();

	/**
	 * Returns the value of the '<em><b>Repeat</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat</em>' attribute.
	 * @see #setRepeat(int)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCompositePipeline_Repeat()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getRepeat();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CompositePipeline#getRepeat <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat</em>' attribute.
	 * @see #getRepeat()
	 * @generated
	 */
	void setRepeat(int value);

} // CompositePipeline
