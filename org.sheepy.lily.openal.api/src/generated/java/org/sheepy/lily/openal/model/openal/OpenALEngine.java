/**
 */
package org.sheepy.lily.openal.model.openal;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.resource.ResourcePkg;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open AL Engine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.openal.model.openal.OpenALEngine#getResourcePkg <em>Resource Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.openal.model.openal.OpenalPackage#getOpenALEngine()
 * @model
 * @generated
 */
public interface OpenALEngine extends IEngine
{

	/**
	 * Returns the value of the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Pkg</em>' containment reference.
	 * @see #setResourcePkg(ResourcePkg)
	 * @see org.sheepy.lily.openal.model.openal.OpenalPackage#getOpenALEngine_ResourcePkg()
	 * @model containment="true"
	 * @generated
	 */
	ResourcePkg getResourcePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.openal.model.openal.OpenALEngine#getResourcePkg <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Pkg</em>' containment reference.
	 * @see #getResourcePkg()
	 * @generated
	 */
	void setResourcePkg(ResourcePkg value);

} // OpenALEngine
